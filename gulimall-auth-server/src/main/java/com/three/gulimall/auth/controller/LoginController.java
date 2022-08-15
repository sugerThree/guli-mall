package com.three.gulimall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.three.common.constant.AuthServerConstant;
import com.three.common.exception.BizCodeEnume;
import com.three.common.utils.R;
import com.three.gulimall.auth.feign.MemberFeignService;
import com.three.gulimall.auth.feign.ThirdPartFeignService;
import com.three.gulimall.auth.vo.UserRegistVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author three
 * @date 2022-08-14 18:42
 */
@Controller
public class LoginController {
    @Autowired
    ThirdPartFeignService thirdPartFeignService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    MemberFeignService memberFeignService;

    @ResponseBody
    @GetMapping("/sms/sendCode")
    public R sendCode(@RequestParam("phone") String phone) {
        //1、接口防刷
        String redisCode = stringRedisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (!StringUtils.isEmpty(redisCode)) {
            //活动存入redis的时间，用当前时间减去存入redis的时间，判断用户手机号是否在60s内发送验证码
            long currentTime = Long.parseLong(redisCode.split("_")[1]);
            int s = 60000;
            if (System.currentTimeMillis() - currentTime < s) {
                //60s内不能再发
                return R.error(BizCodeEnume.SMS_CODE_EXCEPTION.getCode(), BizCodeEnume.SMS_CODE_EXCEPTION.getMsg());
            }
        }

        //2、验证码的再次效验 redis.存key-phone,value-code   sms:code:phone ---> code
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        String codeNum = String.valueOf(code);
        String redisStorage = codeNum + "_" + System.currentTimeMillis();

        //存入redis，防止同一个手机号在60秒内再次发送验证码
        stringRedisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone,
                redisStorage, 10, TimeUnit.MINUTES);

        thirdPartFeignService.sendCode(phone, codeNum);

        return R.ok();
    }

    /**
     * TODO: 重定向携带数据：利用session原理，将数据放在session中。
     * TODO:只要跳转到下一个页面取出这个数据以后，session里面的数据就会删掉
     * TODO：分布下session问题
     * RedirectAttributes：重定向也可以保留数据，不会丢失
     * 用户注册
     *
     * @return
     */
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(fieldError -> {
                return fieldError.getField();
            }, fieldError -> {
                return fieldError.getDefaultMessage();
            }));
            redirectAttributes.addFlashAttribute("errors", errors);
            //如果校验出错,重定向到注册页(转发会重复提交表单)
            return "redirect:http://auth.gulimall.com/reg.html";
        }
        //1.校验验证码
        String code = vo.getCode();
        String s = stringRedisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
        if (!StringUtils.isEmpty(s)) {
            if (code.equals(s.split("_")[0])) {
                //验证码通过
                //删除验证码;令牌机制
                stringRedisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + vo.getPhone());
                //调用远程服务,注册
                R r = memberFeignService.regist(vo);
                if (r.getCode() == 0) {
                    //注册成功
                    return "redirect:http://auth.gulimall.com/login.html";
                } else {
                    Map<String, String> errors = new HashMap<>();
                    errors.put("msg", r.getData("msg", new TypeReference<String>() {
                    }));
                    redirectAttributes.addFlashAttribute("errors", errors);
                    return "redirect:http://auth.gulimall.com/reg.html";
                }
            } else {
                Map<String, String> errors = new HashMap<>();
                errors.put("code", "验证码错误");
                redirectAttributes.addFlashAttribute("errors", errors);
                return "redirect:http://auth.gulimall.com/reg.html";
            }
        } else {
            Map<String, String> errors = new HashMap<>();
            errors.put("code", "验证码错误");
            redirectAttributes.addFlashAttribute("errors", errors);
            return "redirect:http://auth.gulimall.com/reg.html";
        }
    }
}
