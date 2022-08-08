package com.three.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-29 23:45:14
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfoDesc(SpuInfoDescEntity descEntity);
}

