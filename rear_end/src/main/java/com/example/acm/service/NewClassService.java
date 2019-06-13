
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.NewClass;

/** 
 * 新闻_类表服务接口
 *
 * @author xgg
 * @date 2019-01-22 22:47:10
 */
public interface NewClassService{
    
    /** 
     * 添加新闻_类表
     * 
     * @param newClass 新闻_类表
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void addNewClass(NewClass newClass);
    
    /** 
     * 添加新闻_类表列表
     * 
     * @param list 新闻_类表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void addNewClassList(List<NewClass> list);      
    
    /** 
     * 删除新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void deleteNewClassByNewClassId(Long newClassId);
    
    /**
     * 修改新闻_类表
     * 
     * @param newClassId  
     * @param newClass 新闻_类表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void updateNewClassByNewClassId(Long newClassId, NewClass newClass);
    
    /** 
     * 根据获取新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public NewClass getNewClassByNewClassId(Long newClassId);

    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @param newClass 新闻_类表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByNewClassId(Long newClassId);
    
    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClass2MapListByNewClassId(Long newClassId);

    /**
     * 获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassList();
    
    /**
     * 获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClass2MapList();
    
    /**
     * 根据查询条件获取新闻_类表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public Integer countNewClassListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public Integer countNewClassMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClassMapListByQuery(Map<String, Object> map);
	
}
