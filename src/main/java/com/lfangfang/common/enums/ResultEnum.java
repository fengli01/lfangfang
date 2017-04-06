package com.lfangfang.common.enums;

/**
 * @Description: webApi返回给app的code
 * @author fengli
 * @date 2017年4月6日 下午1:15:48
 *
 */
public enum ResultEnum
{
    OK(200, "成功"),
    
    NO_TOKEN(310, "未登录"),
    
    BAD_REQUEST(400, "错误请求"),
    
    FORBIDDEN(403, "服务拒绝执行"),
    
    INTERNAL_ERROR(500, "系统错误，请联系管理员"),
    
    NOT_SUPPORTED(505, "非法连接"),
    
    PAGE_NOT_FOUND(404, "页面未找到"),
    
    UNKNOWN(-1, "未知错误"),
    
    BAD_PARAM_REQUEST(601, "参数错误请求"),
    
    FAILE(9999, "系统错误");
    
    private Integer code;
    
    private String desc;// 描述
    
    private ResultEnum(Integer code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }
    
    public String getDesc()
    {
        
        return desc;
    }
    
    public void setDesc(String desc)
    {
        
        this.desc = desc;
    }
    
    public Integer getCode()
    {
        return code;
    }
    
    public String getStrCode()
    {
        return code.toString();
    }
}
