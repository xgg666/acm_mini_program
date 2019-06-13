
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.NewClass;

/** 
 * 新闻_类表数据操作接口
 *
 * @author xgg
 * @date 2019-01-22 22:47:10
 */
public interface NewClassMapper{
    
    /** 
     * 添加新闻_类表
     * 
     * @param newClass 新闻_类表
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void addNewClass(@Param("newClass") NewClass newClass);
    
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
    public void deleteNewClassByNewClassId(@Param("newClassId") Long newClassId);
    
    /**
     * 修改新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void updateNewClassByNewClassId(@Param("newClassId") Long newClassId, @Param("newClass") NewClass newClass);
    
    /** 
     * 根据获取新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public NewClass getNewClassByNewClassId(@Param("newClassId") Long newClassId);
    
    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByNewClassId(@Param("newClassId") Long newClassId);
    
    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClass2MapListByNewClassId(@Param("newClassId") Long newClassId);

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
    public Integer countNewClassListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public Integer countNewClassMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻_类表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClassMapListByQuery(@Param("map") Map<String, Object> map);
	
}
