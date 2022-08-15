package com.three.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.product.entity.AttrEntity;
import com.three.gulimall.product.vo.AttrGroupRelationVo;
import com.three.gulimall.product.vo.AttrRespVo;
import com.three.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-29 23:45:14
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);

    /**
     * 在指定的所有属性集合里面，挑出检索属性
     * @param attrIds
     * @return
     */
    List<Long> selectSearchAttrs(List<Long> attrIds);
}

