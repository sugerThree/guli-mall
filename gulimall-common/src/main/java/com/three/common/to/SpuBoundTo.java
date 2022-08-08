package com.three.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author three
 * @date 2022-08-07 0:09
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
