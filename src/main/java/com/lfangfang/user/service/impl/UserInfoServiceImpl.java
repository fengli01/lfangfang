package com.lfangfang.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfangfang.user.dao.UserInfoMapper;
import com.lfangfang.user.model.UserInfo;
import com.lfangfang.user.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService
{
    Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Override
    public int addUser(UserInfo userInfo)
    {
        LOGGER.info("userInfo:" + userInfo);
        
        return userInfoMapper.insertSelective(userInfo);
    }
    
}