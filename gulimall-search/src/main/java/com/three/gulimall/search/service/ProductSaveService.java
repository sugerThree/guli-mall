package com.three.gulimall.search.service;

import com.three.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author three
 * @date 2022-08-09 14:47
 */
public interface  ProductSaveService {
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
