package com.three.gulimall.auth.feign;

import com.three.common.utils.R;
import com.three.gulimall.auth.vo.UserRegistVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author three
 * @date 2022-08-15 1:00
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {
    /**
     * 远程调用注册
     * @param vo
     * @return
     */
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo vo);
}
