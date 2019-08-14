package com.xiao.gmall.gmallusermanage.service.impl;

import com.xiao.gmall.gmallusermanage.bean.UserInfo;
import com.xiao.gmall.gmallusermanage.mapper.UserInfoMapper;
import com.xiao.gmall.gmallusermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void inSetInTo(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updataByName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public List<UserInfo> selectByLoginName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public void deleteById(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }
}
