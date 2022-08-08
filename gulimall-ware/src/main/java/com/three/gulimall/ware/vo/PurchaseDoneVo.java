package com.three.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author three
 * @date 2022-08-07 21:31
 */
@Data
public class PurchaseDoneVo {

    @NotNull
    private Long id;
    private List<PurchaseItemDoneVo> items;
}
