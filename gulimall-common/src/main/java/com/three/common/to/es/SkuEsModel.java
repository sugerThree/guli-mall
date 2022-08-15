package com.three.common.to.es;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * sku在es中保存的数据模型
 *
 * @author three
 */
@Data
public class SkuEsModel {

    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private BigDecimal skuPrice;

    private String skuImg;

    /**
     * 销量
     */
    private Long saleCount;

    /**
     * 是否有库存
     */
    private Boolean hasStock;

    /**
     * 热度评分
     */
    private Long hotScore;

    private Long brandId;

    private Long catalogId;

    private String brandName;

    private String brandImg;

    private String catalogName;

    /**
     * 规格属性
     */
    private List<Attrs> attrs;

    @Data
    public static class Attrs {

        private Long attrId;

        private String attrName;

        private String attrValue;

    }

}
