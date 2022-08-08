package com.three.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.ware.entity.PurchaseEntity;
import com.three.gulimall.ware.vo.MergeVo;
import com.three.gulimall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 01:14:16
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}

