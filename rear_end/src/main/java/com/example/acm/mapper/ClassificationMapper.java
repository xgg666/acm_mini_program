
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.Classification;


public interface ClassificationMapper{
    

    public void addClassification(@Param("classification") Classification classification);
    

    public void addClassificationList(List<Classification> list);       

    public void deleteClassificationByClassId(@Param("classId") Long classId);

    public void updateClassificationByClassId(@Param("classId") Long classId, @Param("classification") Classification classification);
    

    public Classification getClassificationByClassId(@Param("classId") Long classId);

    public List<Classification> findClassificationListByClassId(@Param("classId") Long classId);

    public List<Map<String,Object>> findClassification2MapListByClassId(@Param("classId") Long classId);


    public List<Classification> findClassificationList();

    public List<Map<String,Object>> findClassification2MapList();
    

    public Integer countClassificationListByQuery(@Param("map") Map<String, Object> map);

    public List<Classification> findClassificationListByQuery(@Param("map") Map<String, Object> map);
    

    public Integer countClassificationMapListByQuery(@Param("map") Map<String, Object> map);
    

    public List<Map<String,Object>> findClassificationMapListByQuery(@Param("map") Map<String, Object> map);

    public List<Classification> findNewsClasfication(@Param("map") Map<String, Object> map);
}
