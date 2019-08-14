package com.xiao.gmall.gmallusermanage.service;

import com.xiao.gmall.gmallusermanage.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectAll();
    void inSetInTo(UserInfo userInfo);

    void updataByName(UserInfo userInfo);

    List<UserInfo> selectByLoginName(UserInfo userInfo);

    void deleteById(UserInfo userInfo);
}
