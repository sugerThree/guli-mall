package com.three.gulimall.coupon.dao;

import com.three.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 00:50:00
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
