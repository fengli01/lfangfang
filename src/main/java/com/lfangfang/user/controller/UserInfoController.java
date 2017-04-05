package com.lfangfang.user.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lfangfang.user.model.UserInfo;
import com.lfangfang.user.service.UserInfoService;

@RestController
@RequestMapping("/api/userinfo")
public class UserInfoController
{
    @Resource
    private UserInfoService userInfoService;
    
    @PostMapping("/add")
    public void add(UserInfo userInfo)
    {
        userInfoService.addUser(userInfo);
    }
}
