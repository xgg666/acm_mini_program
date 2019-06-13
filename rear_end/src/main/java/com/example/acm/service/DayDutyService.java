
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.DayDuty;

/** 
 * 值日服务接口
 *
 * @author xgg
 * @date 2019-02-14 21:45:45
 */
public interface DayDutyService{
    
    /** 
     * 添加值日
     * 
     * @param dayDuty 值日
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void addDayDuty(DayDuty dayDuty);
    
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
    public void deleteDayDutyByDayDutyId(Integer dayDutyId);
    
    /**
     * 修改值日
     * 
     * @param dayDutyId  
     * @param dayDuty 值日信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void updateDayDutyByDayDutyId(Integer dayDutyId, DayDuty dayDuty);
    
    /** 
     * 根据获取值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public DayDuty getDayDutyByDayDutyId(Integer dayDutyId);

    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @param dayDuty 值日信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByDayDutyId(Integer dayDutyId);
    
    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDuty2MapListByDayDutyId(Integer dayDutyId);

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
    public Integer countDayDutyListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public Integer countDayDutyMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取值日列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDutyMapListByQuery(Map<String, Object> map);
	
}
