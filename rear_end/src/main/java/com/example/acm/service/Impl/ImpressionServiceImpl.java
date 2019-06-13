
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.Impression;
import com.example.acm.mapper.ImpressionMapper;
import com.example.acm.service.ImpressionService;

/** 
 * 印象服务
 *
 * @author xgg
 * @date 2019-04-11 11:54:19
 */
@Service("impressionService")
@Transactional
public class ImpressionServiceImpl implements ImpressionService {
	
	@Autowired
	private ImpressionMapper  impressionMapper;	
    
    /** 
     * 添加印象
     * 
     * @param impression 印象
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void addImpression(Impression impression){
        impressionMapper.addImpression(impression);
    }    
    
    /** 
     * 添加印象列表
     * 
     * @param list 印象列表
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void addImpressionList(List<Impression> list){
        impressionMapper.addImpressionList(list);
    }
    
    /** 
     * 删除印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void deleteImpressionByImpressionId(Long impressionId){
        impressionMapper.deleteImpressionByImpressionId(impressionId);
    }
    
    /**
     * 修改印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public void updateImpressionByImpressionId(Long impressionId,Impression impression){
        impressionMapper.updateImpressionByImpressionId(impressionId,impression);
    }
    
    /** 
     * 根据获取印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Impression getImpressionByImpressionId(Long impressionId){
        return impressionMapper.getImpressionByImpressionId(impressionId);        
    }
    
    /**
     * 查询印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByImpressionId(Long impressionId){
        return impressionMapper.findImpressionListByImpressionId(impressionId);
    }
    
    /**
     * 查询印象
     * 
     * @param impressionId  
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpression2MapListByImpressionId(Long impressionId){
        return impressionMapper.findImpression2MapListByImpressionId(impressionId);
    }

    /**
     * 获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionList(){
        return impressionMapper.findImpressionList();
    }
    
    /**
     * 获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpression2MapList(){
        return impressionMapper.findImpression2MapList();
    }
    
    /**
     * 根据查询条件获取印象个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Integer countImpressionListByQuery(Map<String, Object> map){
    	return impressionMapper.countImpressionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取印象列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Impression> findImpressionListByQuery(Map<String, Object> map){
    	return impressionMapper.findImpressionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取印象个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public Integer countImpressionMapListByQuery(Map<String, Object> map){
    	return impressionMapper.countImpressionMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取印象列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-04-11 11:54:19
     */
    public List<Map<String,Object>> findImpressionMapListByQuery(Map<String, Object> map){
    	return impressionMapper.findImpressionMapListByQuery(map);
    }

}
