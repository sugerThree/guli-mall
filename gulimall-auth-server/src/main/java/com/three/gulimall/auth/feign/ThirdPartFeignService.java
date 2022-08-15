package com.three.gulimall.auth.feign;

import com.three.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author three
 * @date 2022-08-14 22:28
 */
@FeignClient("gulimall-third-party")
public interface ThirdPartFeignService {
    /**
     * 远程调用发送短信验证码功能
     *
     * @param phone
     * @param code
     * @return
     */
    @GetMapping(value = "/sms/sendCode")
    R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
