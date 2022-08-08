package com.three.gulimall.product.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2022-08-06 17:43:36
 *
 * @author www.jsons.cn
 * @website http://www.jsons.cn/json2java/
 */
@Data
public class SpuSaveVo {

    /**
     * 商品名
     */
    private String spuName;
    /**
     * 商品说明
     */
    private String spuDescription;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 商品重量
     */
    private BigDecimal weight;
    /**
     * 发布状态
     */
    private int publishStatus;
    /**
     * 描述图集（图片地址集合）
     */
    private List<String> decript;
    /**
     * 商品图集（图片地址集合）
     */
    private List<String> images;
    /**
     * 积分设置（金币积分/成长值）
     */
    private Bounds bounds;
    /**
     * 基本属性（规格参数）
     */
    private List<BaseAttrs> baseAttrs;
    /**
     * sku属性
     */
    private List<Skus> skus;

}
