package com.lfangfang.common.result;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页查询结果集
 * @author fengli
 * @date 2017年4月6日 下午1:17:35
 *
 * @param <T>
 */
public class QueryResult<T> implements Serializable
{
    
    private static final long serialVersionUID = 461900815434592315L;
    
    private List<T> list;
    private long total;
    
    public QueryResult()
    {
        
    }
    
    public QueryResult(List<T> list, long total)
    {
        super();
        this.list = list;
        this.total = total;
    }
    
    public List<T> getlist()
    {
        return list;
    }
    
    public void setlist(List<T> list)
    {
        this.list = list;
    }
    
    public long getTotal()
    {
        return total;
    }
    
    public void setTotal(long total)
    {
        this.total = total;
    }
}
