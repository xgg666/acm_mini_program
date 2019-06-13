/**
 * Copyright (C) 2017 FACETHINK
 *
 * @className com.example.acm.service.AttendanceServiceImpl
 * @version v1.0.0 
 * @author xgg
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019-03-29      xgg      v1.0.0      create
 *
 */
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.Attendance;
import com.example.acm.mapper.AttendanceMapper;
import com.example.acm.service.AttendanceService;

/** 
 * 签到服务
 *
 * @author xgg
 * @date 2019-03-29 17:03:29
 */
@Service("attendanceService")
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private AttendanceMapper  attendanceMapper;	
    
    /** 
     * 添加签到
     * 
     * @param attendance 签到
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void addAttendance(Attendance attendance){
        attendanceMapper.addAttendance(attendance);
    }    
    
    /** 
     * 添加签到列表
     * 
     * @param list 签到列表
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void addAttendanceList(List<Attendance> list){
        attendanceMapper.addAttendanceList(list);
    }
    
    /** 
     * 删除签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void deleteAttendanceByAttendenceId(Long attendenceId){
        attendanceMapper.deleteAttendanceByAttendenceId(attendenceId);
    }
    
    /**
     * 修改签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void updateAttendanceByAttendenceId(Long attendenceId,Attendance attendance){
        attendanceMapper.updateAttendanceByAttendenceId(attendenceId,attendance);
    }
    
    /** 
     * 根据获取签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Attendance getAttendanceByAttendenceId(Long attendenceId){
        return attendanceMapper.getAttendanceByAttendenceId(attendenceId);        
    }
    
    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByAttendenceId(Long attendenceId){
        return attendanceMapper.findAttendanceListByAttendenceId(attendenceId);
    }
    
    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendance2MapListByAttendenceId(Long attendenceId){
        return attendanceMapper.findAttendance2MapListByAttendenceId(attendenceId);
    }

    /**
     * 获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceList(){
        return attendanceMapper.findAttendanceList();
    }
    
    /**
     * 获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendance2MapList(){
        return attendanceMapper.findAttendance2MapList();
    }
    
    /**
     * 根据查询条件获取签到个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Integer countAttendanceListByQuery(Map<String, Object> map){
    	return attendanceMapper.countAttendanceListByQuery(map);
    }
    
    /**
     * 根据查询条件获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByQuery(Map<String, Object> map){
    	return attendanceMapper.findAttendanceListByQuery(map);
    }
    
    /**
     * 根据查询条件获取签到个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Integer countAttendanceMapListByQuery(Map<String, Object> map){
    	return attendanceMapper.countAttendanceMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取签到列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendanceMapListByQuery(Map<String, Object> map){
    	return attendanceMapper.findAttendanceMapListByQuery(map);
    }

}
