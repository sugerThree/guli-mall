package com.three.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.product.entity.AttrGroupEntity;
import com.three.gulimall.product.vo.AttrGroupWithAttrsVo;
import com.three.gulimall.product.vo.SpuItemAttrGroupVo;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-29 23:45:14
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params,Long catelogId);

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}

