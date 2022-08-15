package com.three.gulimall.search.controller;

import com.three.common.exception.BizCodeEnume;
import com.three.common.to.es.SkuEsModel;
import com.three.common.utils.R;
import com.three.gulimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-06-06 16:48
 **/


@Slf4j
@RequestMapping(value = "/search/save")
@RestController
public class ElasticSaveController {

    @Autowired
    private ProductSaveService productSaveService;

    /**
     * 上架商品
     * @param skuEsModels
     * @return
     */
    @PostMapping(value = "/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels) {
        boolean status=false;
        try {
            status = productSaveService.productStatusUp(skuEsModels);
        } catch (IOException e) {
            //log.error("商品上架错误{}",e);
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(),
                    BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
        if(status){
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(),
                    BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }else {
            return R.ok();
        }
    }

}
