package com.three.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.three.gulimall.product.entity.BrandEntity;
import com.three.gulimall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
        /*BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setDescript("苹果");
        brandEntity.setName("Apple");
        brandService.save(brandEntity);
        System.out.println("保存成功");
        brandService.updateById(brandEntity);*/

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1l));
        list.stream().forEach(brandEntity -> System.out.println(brandEntity));
    }

}
