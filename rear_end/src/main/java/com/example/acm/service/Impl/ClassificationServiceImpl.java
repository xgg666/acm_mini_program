
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.Classification;
import com.example.acm.mapper.ClassificationMapper;
import com.example.acm.service.ClassificationService;

/** 
 * 新闻分类表服务
 *
 * @author xgg
 * @date 2019-01-10 21:05:22
 */
@Service("classificationService")
@Transactional
public class ClassificationServiceImpl implements ClassificationService {
	
	@Autowired
	private ClassificationMapper  classificationMapper;	
    
    /** 
     * 添加新闻分类表
     * 
     * @param classification 新闻分类表
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void addClassification(Classification classification){
        classificationMapper.addClassification(classification);
    }    
    
    /** 
     * 添加新闻分类表列表
     * 
     * @param list 新闻分类表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void addClassificationList(List<Classification> list){
        classificationMapper.addClassificationList(list);
    }
    
    /** 
     * 删除新闻分类表
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void deleteClassificationByClassId(Long classId){
        classificationMapper.deleteClassificationByClassId(classId);
    }
    
    /**
     * 修改新闻分类表
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void updateClassificationByClassId(Long classId,Classification classification){
        classificationMapper.updateClassificationByClassId(classId,classification);
    }
    
    /** 
     * 根据获取新闻分类表
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Classification getClassificationByClassId(Long classId){
        return classificationMapper.getClassificationByClassId(classId);        
    }
    
    /**
     * 查询新闻分类表
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationListByClassId(Long classId){
        return classificationMapper.findClassificationListByClassId(classId);
    }
    
    /**
     * 查询新闻分类表
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassification2MapListByClassId(Long classId){
        return classificationMapper.findClassification2MapListByClassId(classId);
    }

    /**
     * 获取新闻分类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationList(){
        return classificationMapper.findClassificationList();
    }
    
    /**
     * 获取新闻分类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassification2MapList(){
        return classificationMapper.findClassification2MapList();
    }
    
    /**
     * 根据查询条件获取新闻分类表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Integer countClassificationListByQuery(Map<String, Object> map){
    	return classificationMapper.countClassificationListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻分类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationListByQuery(Map<String, Object> map){
    	return classificationMapper.findClassificationListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻分类表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Integer countClassificationMapListByQuery(Map<String, Object> map){
    	return classificationMapper.countClassificationMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻分类表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassificationMapListByQuery(Map<String, Object> map){
    	return classificationMapper.findClassificationMapListByQuery(map);
    }

    public List<Classification> findNewsClasfication(@Param("map") Map<String, Object> map){
        return classificationMapper.findNewsClasfication(map);
    }
}
