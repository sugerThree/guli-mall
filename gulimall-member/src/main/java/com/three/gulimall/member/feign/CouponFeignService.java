package com.three.gulimall.member.feign;

import com.three.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author three
 * @date 2022-07-30 15:23
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 远程调用测试接口
     * 路径要写全
     *
     * @return
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupon();
}
