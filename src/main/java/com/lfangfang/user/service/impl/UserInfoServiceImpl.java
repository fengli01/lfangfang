package com.lfangfang.user.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lfangfang.common.result.QueryResult;
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
    
    @Override
    public int remove(int id)
    {
        LOGGER.info("id:" + id);
        
        return userInfoMapper.deleteByPrimaryKey(id);
    }
    
    @Override
    public int modifyUser(UserInfo userInfo)
    {
        LOGGER.info("userInfo:" + userInfo);
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
    
    @Override
    public UserInfo findById(int id)
    {
        LOGGER.info("id:" + id);
        return userInfoMapper.selectByPrimaryKey(id);
    }
    
    @Override
    public QueryResult<UserInfo> findByPage(Integer pageNumber, Integer pageSize)
    {
        Page<UserInfo> page = PageHelper.startPage(pageNumber, pageSize);
        List<UserInfo> list = userInfoMapper.selectAll();
        QueryResult<UserInfo> result = new QueryResult<>(list, page.getTotal());
        return result;
    }
    
}
