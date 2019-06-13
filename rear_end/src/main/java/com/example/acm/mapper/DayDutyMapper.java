
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.DayDuty;

/** 
 * 值日数据操作接口
 *
 * @author xgg
 * @date 2019-02-14 21:45:45
 */
public interface DayDutyMapper{
    
    /** 
     * 添加值日
     * 
     * @param dayDuty 值日
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void addDayDuty(@Param("dayDuty") DayDuty dayDuty);
    
    /** 
     * 添加值日列表
     * 
     * @param list 值日列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void addDayDutyList(List<DayDuty> list);       
    
    /** 
     * 删除值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void deleteDayDutyByDayDutyId(@Param("dayDutyId") Integer dayDutyId);
    
    /**
     * 修改值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void updateDayDutyByDayDutyId(@Param("dayDutyId") Integer dayDutyId, @Param("dayDuty") DayDuty dayDuty);
    
    /** 
     * 根据获取值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public DayDuty getDayDutyByDayDutyId(@Param("dayDutyId") Integer dayDutyId);
    
    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByDayDutyId(@Param("dayDutyId") Integer dayDutyId);
    
    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDuty2MapListByDayDutyId(@Param("dayDutyId") Integer dayDutyId);

    /**
     * 获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyList();
    
    /**
     * 获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDuty2MapList();
    
    /**
     * 根据查询条件获取值日个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public Integer countDayDutyListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public Integer countDayDutyMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDutyMapListByQuery(@Param("map") Map<String, Object> map);
	
}
