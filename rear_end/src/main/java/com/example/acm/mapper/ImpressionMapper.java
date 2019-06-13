
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import com.example.acm.returnView.UserImpression;
import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.Impression;

/** 
 * 印象数据操作接口
 *
 * @author xgg
 * @date 2019-04-11 11:54:19
 */
public interface ImpressionMapper{
    
    /** 
     * 添加印象
     * 
     * @param impression 印象
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void addImpression(@Param("impression") Impression impression);
    
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
    public void deleteImpressionByImpressionId(@Param("impressionId") Long impressionId);
    
    /**
     * 修改印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void updateImpressionByImpressionId(@Param("impressionId") Long impressionId, @Param("impression") Impression impression);
    
    /** 
     * 根据获取印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Impression getImpressionByImpressionId(@Param("impressionId") Long impressionId);
    
    /**
     * 查询印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByImpressionId(@Param("impressionId") Long impressionId);
    
    /**
     * 查询印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpression2MapListByImpressionId(@Param("impressionId") Long impressionId);

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
    public Integer countImpressionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Integer countImpressionMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取印象列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpressionMapListByQuery(@Param("map") Map<String, Object> map);

    public List<UserImpression> findUserImpression(@Param("map") Map<String, Object> map);
	
}
