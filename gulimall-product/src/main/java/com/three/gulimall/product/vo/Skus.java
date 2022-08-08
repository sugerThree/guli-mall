/**
  * Copyright 2019 bejson.com 
  */
package com.three.gulimall.product.vo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Auto-generated: 2019-11-26 10:50:34
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Skus {

    /**
     * 属性列表
     */
    private List<Attr> attr;
    /**
     * sku名称列表
     */
    private String skuName;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 标题
     */
    private String skuTitle;
    /**
     * 副标题
     */
    private String skuSubtitle;
    /**
     * sku图集
     */
    private List<Images> images;
    /**
     * 属性组合集合
     */
    private List<String> descar;
    /**
     * 满几件。。。
     */
    private int fullCount;
    /**
     * 折扣
     */
    private BigDecimal discount;
    private int countStatus;
    /**
     * 满。。。减
     */
    private BigDecimal fullPrice;
    /**
     * 降价
     */
    private BigDecimal reducePrice;
    private int priceStatus;
    /**
     * 设置会员价
     */
    private List<MemberPrice> memberPrice;


}