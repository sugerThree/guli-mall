package com.three.gulimall.member.service.impl;

import com.three.gulimall.member.dao.MemberLevelDao;
import com.three.gulimall.member.entity.MemberLevelEntity;
import com.three.gulimall.member.exception.PhoneExistException;
import com.three.gulimall.member.exception.UserNameExistException;
import com.three.gulimall.member.vo.MemberRegistVo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.three.common.utils.PageUtils;
import com.three.common.utils.Query;

import com.three.gulimall.member.dao.MemberDao;
import com.three.gulimall.member.entity.MemberEntity;
import com.three.gulimall.member.service.MemberService;

import javax.annotation.Resource;


/**
 * @author three
 */
@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Resource
    MemberLevelDao memberLevelDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void regist(MemberRegistVo vo) {
        MemberDao dao = this.baseMapper;
        MemberEntity entity = new MemberEntity();
        //设置默认用户等级
        MemberLevelEntity levelEntity = memberLevelDao.getDefaultLevel();
        entity.setLevelId(levelEntity.getId());
        //检查数据是否唯一,为了让controller感知异常,异常机制
        checkPhoneUnique(vo.getPhone());
        checkUserNameUnique(vo.getUserName());
        entity.setMobile(vo.getPhone());
        entity.setUsername(vo.getUserName());
        entity.setNickname(vo.getUserName());
        //密码加密存储
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(vo.getPassword());
        entity.setPassword(encode);
        dao.insert(entity);
        //其它默认信息
    }

    @Override
    public void checkPhoneUnique(String phone) throws PhoneExistException {
        MemberDao dao = this.baseMapper;
        Integer mobile = dao.selectCount(new QueryWrapper<MemberEntity>().eq("mobile", phone));
        if (mobile > 0) {
            throw new PhoneExistException();
        }
    }

    @Override
    public void checkUserNameUnique(String userName) throws UserNameExistException {
        MemberDao dao = this.baseMapper;
        Integer cout = dao.selectCount(new QueryWrapper<MemberEntity>().eq("username", userName));
        if (cout > 0) {
            throw new UserNameExistException();
        }
    }

}