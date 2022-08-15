package com.three.gulimall.product.feign;

import com.three.common.to.es.SkuEsModel;
import com.three.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author three
 * @date 2022-08-09 12:13
 */
@FeignClient("gulimall-search")
public interface SearchFeignService {
    /**
     * 将数据上传至es
     * @param skuEsModels
     * @return
     */
    @PostMapping(value = "/search/save/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
