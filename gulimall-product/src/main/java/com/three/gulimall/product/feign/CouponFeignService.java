package com.three.gulimall.product.feign;

import com.three.common.to.SkuReductionTo;
import com.three.common.to.SpuBoundTo;
import com.three.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author three
 * @date 2022-07-30 15:23
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     * 1、CouponFeignService.saveSpuBounds(spuBoundTo);
     * 1）、@RequestBody将这个对象转为json。
     * 2）、找到gulimall-coupon服务，给/coupon/spubounds/save发送请求。
     * 将上一步转的json放在请求体位置，发送请求；
     * 3）、对方服务收到请求。请求体里有json数据。
     * (@RequestBody SpuBoundsEntity spuBounds)；将请求体的json转为SpuBoundsEntity；
     * 只要json数据模型是兼容的。双方服务无需使用同一个to
     * <p>
     * 远程调用保存积分信息
     *
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    /**
     * 远程调用满减/折扣
     *
     * @param skuReductionTo
     * @return
     */
    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
