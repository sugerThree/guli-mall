package com.three.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author three
 * @date 2022-08-07 0:30
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
