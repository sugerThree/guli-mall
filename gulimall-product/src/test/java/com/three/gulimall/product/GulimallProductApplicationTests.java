package com.three.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.three.gulimall.product.dao.AttrGroupDao;
import com.three.gulimall.product.entity.BrandEntity;
import com.three.gulimall.product.service.BrandService;
import com.three.gulimall.product.service.CategoryService;
import com.three.gulimall.product.vo.SpuItemAttrGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Resource
    AttrGroupDao attrGroupDao;

    @Test
    public void redissonTest() {
        System.out.println(redissonClient);
    }

    @Test
    public void redisTest() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello", "world_" + UUID.randomUUID().toString());

        String s = ops.get("hello");
        System.out.println(s);
    }

    @Test
    public void testFindCatelogPath() {
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("完整路径：{}", Arrays.asList(catelogPath));
    }

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

    @Test
    public void test() {
        List<SpuItemAttrGroupVo> attrGroupWithAttrsBySpuId = attrGroupDao.getAttrGroupWithAttrsBySpuId(13L, 225L);
        System.out.println(attrGroupWithAttrsBySpuId);
    }
}
