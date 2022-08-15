package com.three.gulimall.product.web;

import com.three.gulimall.product.service.SkuInfoService;
import com.three.gulimall.product.vo.SkuItemVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @author three
 * @date 2022-08-14 2:04
 */
@Controller
public class ItemController {
    @Resource
    SkuInfoService skuInfoService;

    @GetMapping("/{skuId}.html")
    public String skuItem(@PathVariable("skuId") Long skuId,
                          Model model) throws ExecutionException, InterruptedException {
        SkuItemVo vos = skuInfoService.item(skuId);

        model.addAttribute("item",vos);

        return "item";
    }
}
