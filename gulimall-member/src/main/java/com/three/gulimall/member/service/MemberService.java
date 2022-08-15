package com.three.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.three.common.utils.PageUtils;
import com.three.gulimall.member.entity.MemberEntity;
import com.three.gulimall.member.exception.PhoneExistException;
import com.three.gulimall.member.exception.UserNameExistException;
import com.three.gulimall.member.vo.MemberRegistVo;

import java.util.Map;

/**
 * 会员
 *
 * @author three
 * @email sunlightcs@gmail.com
 * @date 2022-07-30 01:07:20
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 用户注册
     *
     * @param vo
     */
    void regist(MemberRegistVo vo);

    /**
     * 判断邮箱是否重复
     *
     * @param phone
     * @return
     */
    void checkPhoneUnique(String phone) throws PhoneExistException;

    /**
     * 判断用户名是否重复
     *
     * @param userName
     * @return
     */
    void checkUserNameUnique(String userName) throws UserNameExistException;
}

