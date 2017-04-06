package com.lfangfang.common.result;

import java.io.Serializable;
import com.lfangfang.common.enums.ResultEnum;

/**
 * @Description: 返回实体
 * @author fengli
 * @date 2017年4月6日 下午1:14:48
 *
 * @param <T>
 */
public class ActionResult<T> implements Serializable
{
    
    private static final long serialVersionUID = 1772055640075900959L;
    
    private int retCode = 200;
    private String retMsg = "操作成功";
    private String reqUrl;
    private T result;
    
    public ActionResult()
    {
        super();
    }
    
    public ActionResult(T result)
    {
        super();
        this.result = result;
    }
    
    public ActionResult(ResultEnum actionResultEnum)
    {
        super();
        this.retCode = actionResultEnum.getCode();
        this.retMsg = actionResultEnum.getDesc();
    }
    
    public ActionResult(int retCode, String retMsg)
    {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    
    public ActionResult(ResultEnum actionResultEnum, T result)
    {
        super();
        this.retCode = actionResultEnum.getCode();
        this.retMsg = actionResultEnum.getDesc();
        this.result = result;
    }
    
    public ActionResult(ResultEnum retCodeEnum, String retMsg, T result)
    {
        super();
        this.retCode = retCodeEnum.getCode();
        this.retMsg = retMsg;
        this.result = result;
    }
    
    public int getRetCode()
    {
        return retCode;
    }
    
    public void setRetCode(int retCode)
    {
        this.retCode = retCode;
    }
    
    public String getRetMsg()
    {
        return retMsg;
    }
    
    public void setRetMsg(String retMsg)
    {
        this.retMsg = retMsg;
    }
    
    public String getReqUrl()
    {
        return reqUrl;
    }
    
    public void setReqUrl(String reqUrl)
    {
        this.reqUrl = reqUrl;
    }
    
    public T getResult()
    {
        return result;
    }
    
    public void setResult(T result)
    {
        this.result = result;
    }
    
    @Override
    public String toString()
    {
        return "ActionResult [retCode=" + retCode + ", retMsg=" + retMsg + ", reqUrl=" + reqUrl + ", result=" + result + "]";
    }
}
