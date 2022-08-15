package com.three.gulimall.product.vo;

import com.three.gulimall.product.entity.SkuImagesEntity;
import com.three.gulimall.product.entity.SkuInfoEntity;
import com.three.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author three
 * @date 2022-08-14 2:26
 */
@Data
@ToString
public class SkuItemVo {
    /**
     * sku基本信息的获取  pms_sku_info
     */
    private SkuInfoEntity info;

    private boolean hasStock = true;
    /**
     * sku的图片信息    pms_sku_images
     */
    private List<SkuImagesEntity> images;
    /**
     * 获取spu的销售属性组合
     */
    private List<SkuItemSaleAttrVo> saleAttr;
    /**
     * 获取spu的介绍
     */
    private SpuInfoDescEntity desc;
    /**
     * 获取spu的规格参数信息
     */
    private List<SpuItemAttrGroupVo> groupAttrs;
    /**
     * 秒杀商品的优惠信息
     */
    // private SeckillSkuVo seckillSkuVo;
}
