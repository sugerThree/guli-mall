package com.three.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.to.SkuReductionTo;
import com.three.common.utils.PageUtils;
import com.three.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 00:50:00
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo reductionTo);
}

