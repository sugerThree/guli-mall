package com.three.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author three
 * @date 2022-08-07 0:28
 */
@Data
public class SkuReductionTo {
    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}
