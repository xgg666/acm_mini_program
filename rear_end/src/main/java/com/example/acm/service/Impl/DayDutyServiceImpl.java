
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.DayDuty;
import com.example.acm.mapper.DayDutyMapper;
import com.example.acm.service.DayDutyService;

/** 
 * 值日服务
 *
 * @author xgg
 * @date 2019-02-14 21:45:45
 */
@Service("dayDutyService")
@Transactional
public class DayDutyServiceImpl implements DayDutyService {
	
	@Autowired
	private DayDutyMapper  dayDutyMapper;	
    
    /** 
     * 添加值日
     * 
     * @param dayDuty 值日
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void addDayDuty(DayDuty dayDuty){
        dayDutyMapper.addDayDuty(dayDuty);
    }    
    
    /** 
     * 添加值日列表
     * 
     * @param list 值日列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void addDayDutyList(List<DayDuty> list){
        dayDutyMapper.addDayDutyList(list);
    }
    
    /** 
     * 删除值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void deleteDayDutyByDayDutyId(Integer dayDutyId){
        dayDutyMapper.deleteDayDutyByDayDutyId(dayDutyId);
    }
    
    /**
     * 修改值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public void updateDayDutyByDayDutyId(Integer dayDutyId,DayDuty dayDuty){
        dayDutyMapper.updateDayDutyByDayDutyId(dayDutyId,dayDuty);
    }
    
    /** 
     * 根据获取值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public DayDuty getDayDutyByDayDutyId(Integer dayDutyId){
        return dayDutyMapper.getDayDutyByDayDutyId(dayDutyId);        
    }
    
    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByDayDutyId(Integer dayDutyId){
        return dayDutyMapper.findDayDutyListByDayDutyId(dayDutyId);
    }
    
    /**
     * 查询值日
     * 
     * @param dayDutyId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDuty2MapListByDayDutyId(Integer dayDutyId){
        return dayDutyMapper.findDayDuty2MapListByDayDutyId(dayDutyId);
    }

    /**
     * 获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyList(){
        return dayDutyMapper.findDayDutyList();
    }
    
    /**
     * 获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDuty2MapList(){
        return dayDutyMapper.findDayDuty2MapList();
    }
    
    /**
     * 根据查询条件获取值日个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public Integer countDayDutyListByQuery(Map<String, Object> map){
    	return dayDutyMapper.countDayDutyListByQuery(map);
    }
    
    /**
     * 根据查询条件获取值日列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<DayDuty> findDayDutyListByQuery(Map<String, Object> map){
    	return dayDutyMapper.findDayDutyListByQuery(map);
    }
    
    /**
     * 根据查询条件获取值日个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public Integer countDayDutyMapListByQuery(Map<String, Object> map){
    	return dayDutyMapper.countDayDutyMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取值日列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-14 21:45:45
     */
    public List<Map<String,Object>> findDayDutyMapListByQuery(Map<String, Object> map){
    	return dayDutyMapper.findDayDutyMapListByQuery(map);
    }

}
