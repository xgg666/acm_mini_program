
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.Classification;
import org.apache.ibatis.annotations.Param;


public interface ClassificationService{
    

    public void addClassification(Classification classification);
    
    /** 
     * 娣诲???伴?诲??绫昏〃??琛?
     * 
     * @param list ?伴?诲??绫昏〃??琛?
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void addClassificationList(List<Classification> list);      
    
    /** 
     * ???ゆ?伴?诲??绫昏〃
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void deleteClassificationByClassId(Long classId);
    
    /**
     * 淇??规?伴?诲??绫昏〃
     * 
     * @param classId  
     * @param classification ?伴?诲??绫昏〃淇℃??
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public void updateClassificationByClassId(Long classId, Classification classification);
    
    /** 
     * ?规???峰???伴?诲??绫昏〃
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Classification getClassificationByClassId(Long classId);

    /**
     * ?ヨ?㈡?伴?诲??绫昏〃
     * 
     * @param classId  
     * @param classification ?伴?诲??绫昏〃淇℃??
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationListByClassId(Long classId);
    
    /**
     * ?ヨ?㈡?伴?诲??绫昏〃
     * 
     * @param classId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassification2MapListByClassId(Long classId);

    /**
     * ?峰???伴?诲??绫昏〃??琛?
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationList();
    
    /**
     * ?峰???伴?诲??绫昏〃??琛?
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassification2MapList();
    
    /**
     * ?规???ヨ?㈡?′欢?峰???伴?诲??绫昏〃涓???
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Integer countClassificationListByQuery(Map<String, Object> map);
    
    /**
     * ?规???ヨ?㈡?′欢?峰???伴?诲??绫昏〃??琛?
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Classification> findClassificationListByQuery(Map<String, Object> map);
    
    /**
     * ?规???ヨ?㈡?′欢?峰???伴?诲??绫昏〃涓???(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public Integer countClassificationMapListByQuery(Map<String, Object> map);
    
    /**
     * ?规???ヨ?㈡?′欢?峰???伴?诲??绫昏〃??琛?(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-10 21:05:22
     */
    public List<Map<String,Object>> findClassificationMapListByQuery(Map<String, Object> map);


    public List<Classification> findNewsClasfication(@Param("map") Map<String, Object> map);
	
}
