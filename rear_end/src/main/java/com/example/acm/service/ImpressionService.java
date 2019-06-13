
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.Impression;

/** 
 * 印象服务接口
 *
 * @author xgg
 * @date 2019-04-11 11:54:19
 */
public interface ImpressionService{
    
    /** 
     * 添加印象
     * 
     * @param impression 印象
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void addImpression(Impression impression);
    
    /** 
     * 添加印象列表
     * 
     * @param list 印象列表
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void addImpressionList(List<Impression> list);      
    
    /** 
     * 删除印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void deleteImpressionByImpressionId(Long impressionId);
    
    /**
     * 修改印象
     * 
     * @param impressionId  
     * @param impression 印象信息
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void updateImpressionByImpressionId(Long impressionId, Impression impression);
    
    /** 
     * 根据获取印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Impression getImpressionByImpressionId(Long impressionId);

    /**
     * 查询印象
     * 
     * @param impressionId  
     * @param impression 印象信息
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByImpressionId(Long impressionId);
    
    /**
     * 查询印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpression2MapListByImpressionId(Long impressionId);

    /**
     * 获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionList();
    
    /**
     * 获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpression2MapList();
    
    /**
     * 根据查询条件获取印象个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Integer countImpressionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Integer countImpressionMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpressionMapListByQuery(Map<String, Object> map);
	
}
