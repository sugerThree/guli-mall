package com.three.gulimall.ware.vo;

import lombok.Data;

/**
 * @author three
 * @date 2022-08-07 21:32
 */
@Data
public class PurchaseItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
