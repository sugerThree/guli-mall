package com.three.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.three.common.utils.PageUtils;
import com.three.common.utils.Query;

import com.three.gulimall.product.dao.CategoryDao;
import com.three.gulimall.product.entity.CategoryEntity;
import com.three.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查询所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 2、组装成父子的树形结构
        // 一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map(menus -> {
            menus.setChildren(getChildren(menus, entities));
            return menus;
        }).sorted((menus1, menus2) -> {
            return (menus1.getSort()==null?0: menus1.getSort()) - (menus2.getSort()==null?0: menus2.getSort());
        }).collect(Collectors.toList());

        return level1Menus;
    }

    /**
     * 递归查询所有菜单的子菜单
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            // 找子菜单
            categoryEntity.setChildren(getChildren(categoryEntity,all));
            return categoryEntity;
        }).sorted((menus1,menus2)->{
            return (menus1.getSort()==null?0: menus1.getSort()) - (menus2.getSort()==null?0: menus2.getSort());
        }).collect(Collectors.toList());
        return children;
    }
}
