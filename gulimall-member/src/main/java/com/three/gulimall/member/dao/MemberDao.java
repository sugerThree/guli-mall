package com.three.gulimall.member.dao;

import com.three.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 01:07:20
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
