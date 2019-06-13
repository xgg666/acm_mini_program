
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.NewClass;
import com.example.acm.mapper.NewClassMapper;
import com.example.acm.service.NewClassService;

/** 
 * 新闻_类表服务
 *
 * @author xgg
 * @date 2019-01-22 22:47:10
 */
@Service("newClassService")
@Transactional
public class NewClassServiceImpl implements NewClassService {
	
	@Autowired
	private NewClassMapper  newClassMapper;	
    
    /** 
     * 添加新闻_类表
     * 
     * @param newClass 新闻_类表
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void addNewClass(NewClass newClass){
        newClassMapper.addNewClass(newClass);
    }    
    
    /** 
     * 添加新闻_类表列表
     * 
     * @param list 新闻_类表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void addNewClassList(List<NewClass> list){
        newClassMapper.addNewClassList(list);
    }
    
    /** 
     * 删除新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void deleteNewClassByNewClassId(Long newClassId){
        newClassMapper.deleteNewClassByNewClassId(newClassId);
    }
    
    /**
     * 修改新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public void updateNewClassByNewClassId(Long newClassId,NewClass newClass){
        newClassMapper.updateNewClassByNewClassId(newClassId,newClass);
    }
    
    /** 
     * 根据获取新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public NewClass getNewClassByNewClassId(Long newClassId){
        return newClassMapper.getNewClassByNewClassId(newClassId);        
    }
    
    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByNewClassId(Long newClassId){
        return newClassMapper.findNewClassListByNewClassId(newClassId);
    }
    
    /**
     * 查询新闻_类表
     * 
     * @param newClassId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClass2MapListByNewClassId(Long newClassId){
        return newClassMapper.findNewClass2MapListByNewClassId(newClassId);
    }

    /**
     * 获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassList(){
        return newClassMapper.findNewClassList();
    }
    
    /**
     * 获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClass2MapList(){
        return newClassMapper.findNewClass2MapList();
    }
    
    /**
     * 根据查询条件获取新闻_类表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public Integer countNewClassListByQuery(Map<String, Object> map){
    	return newClassMapper.countNewClassListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻_类表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<NewClass> findNewClassListByQuery(Map<String, Object> map){
    	return newClassMapper.findNewClassListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻_类表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public Integer countNewClassMapListByQuery(Map<String, Object> map){
    	return newClassMapper.countNewClassMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻_类表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-22 22:47:10
     */
    public List<Map<String,Object>> findNewClassMapListByQuery(Map<String, Object> map){
    	return newClassMapper.findNewClassMapListByQuery(map);
    }

}
