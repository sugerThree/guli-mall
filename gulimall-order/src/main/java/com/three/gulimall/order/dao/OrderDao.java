package com.three.gulimall.order.dao;

import com.three.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 01:11:04
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
