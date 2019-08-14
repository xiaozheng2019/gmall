package com.xiao.gmall.gmallusermanage.controller;

import com.xiao.gmall.gmallusermanage.bean.UserInfo;
import com.xiao.gmall.gmallusermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("selectAll")
    @ResponseBody
    public List<UserInfo> selectAll(){
        return userInfoService.selectAll();
    }

    @RequestMapping("selectByLoginName")
    @ResponseBody
    public List<UserInfo> selectByLoginName(){
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginName("zhang");
        return userInfoService.selectByLoginName(userInfo);
    }


    @RequestMapping("insetInto")
    @ResponseBody
    public void insetInto(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张常久");
        userInfo.setLoginName("zhangsan");
        userInfo.setNickName("常在河边走");
        userInfoService.inSetInTo(userInfo);
    }

    @ResponseBody
    @RequestMapping("updataByName")
    public void updataByName(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张常久");
        userInfo.setPasswd("123456");
        userInfo.setPhoneNum("18866668888");
        userInfoService.updataByName(userInfo);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId("5");
        userInfoService.deleteById(userInfo);
    }
}
