package com.lfangfang.user.controller;

import javax.annotation.Resource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lfangfang.common.controller.BaseController;
import com.lfangfang.common.enums.ResultEnum;
import com.lfangfang.common.result.MessageUtil;
import com.lfangfang.common.result.QueryResult;
import com.lfangfang.user.model.UserInfo;
import com.lfangfang.user.service.UserInfoService;

/**
 * 
 * @Description: TODO
 * @author fengli
 * @date 2017年4月6日 下午1:24:11
 *
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController extends BaseController
{
    @Resource
    private UserInfoService userInfoService;
    
    /**
     * 
     * @Description: 新增
     * @author fengli
     * @date 2017年4月6日 下午1:22:40
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/add")
    public ModelMap add(UserInfo userInfo)
    {
        int count = userInfoService.addUser(userInfo);
        
        return MessageUtil.makeModelMap(ResultEnum.OK.getCode(), count);
    }
    
    /**
     * @Description: 删除
     * @author fengli
     * @date 2017年4月6日 下午1:34:04
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}/remove")
    public ModelMap remove(@PathVariable("id") int id)
    {
        int count = userInfoService.remove(id);
        
        return MessageUtil.makeModelMap(ResultEnum.OK.getCode(), count);
    }
    
    /**
     * @Description: 修改
     * @author fengli
     * @date 2017年4月6日 下午1:34:07
     *
     * @param userInfo
     * @return
     */
    @PutMapping("/modify")
    public ModelMap modify(UserInfo userInfo)
    {
        int count = userInfoService.modifyUser(userInfo);
        
        return MessageUtil.makeModelMap(ResultEnum.OK.getCode(), count);
    }
    
    /**
     * @Description: 查询
     * @author fengli
     * @date 2017年4月6日 下午1:34:10
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}/query")
    public ModelMap findById(@PathVariable("id") int id)
    {
        UserInfo userInfo = userInfoService.findById(id);
        
        return MessageUtil.makeModelMap(ResultEnum.OK.getCode(), userInfo);
    }
    
    /**
     * @Description: 分页查询
     * @author fengli
     * @date 2017年4月14日 下午2:57:13
     *
     * @return
     */
    @GetMapping("/list")
    public ModelMap findAll()
    {
        QueryResult<UserInfo> result = userInfoService.findByPage();
        return MessageUtil.makeModelMap(ResultEnum.OK.getCode(), result);
    }
}
