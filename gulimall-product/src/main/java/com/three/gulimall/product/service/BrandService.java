package com.three.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-29 23:45:14
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}
