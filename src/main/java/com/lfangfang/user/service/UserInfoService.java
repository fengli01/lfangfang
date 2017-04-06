package com.lfangfang.user.service;

import com.lfangfang.user.model.UserInfo;

public interface UserInfoService
{
    /**
     * @Description: 添加用户
     * @author fengli
     * @date 2017年4月5日 下午1:26:08
     *
     * @param userInfo
     * @return
     */
    int addUser(UserInfo userInfo);
    
    /**
     * @Description: 删除用户
     * @author fengli
     * @date 2017年4月6日 下午1:26:06
     *
     * @param id
     * @return
     */
    int remove(int id);
    
    /**
     * @Description: 修改用户
     * @author fengli
     * @date 2017年4月6日 下午1:27:08
     *
     * @param userInfo
     * @return
     */
    int modifyUser(UserInfo userInfo);
    
    /**
     * @Description: 根据id查询
     * @author fengli
     * @date 2017年4月6日 下午1:26:41
     *
     * @param id
     * @return
     */
    UserInfo findById(int id);
}
