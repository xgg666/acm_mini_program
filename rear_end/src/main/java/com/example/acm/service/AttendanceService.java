/**
 * Copyright (C) 2017 FACETHINK
 *
 * @className com.example.acm.service.AttendanceService
 * @version v1.0.0 
 * @author xgg
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2019-03-29      xgg      v1.0.0      create
 *
 */
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.Attendance;

/** 
 * 签到服务接口
 *
 * @author xgg
 * @date 2019-03-29 17:03:29
 */
public interface AttendanceService{
    
    /** 
     * 添加签到
     * 
     * @param attendance 签到
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void addAttendance(Attendance attendance);
    
    /** 
     * 添加签到列表
     * 
     * @param list 签到列表
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void addAttendanceList(List<Attendance> list);      
    
    /** 
     * 删除签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void deleteAttendanceByAttendenceId(Long attendenceId);
    
    /**
     * 修改签到
     * 
     * @param attendenceId  
     * @param attendance 签到信息
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void updateAttendanceByAttendenceId(Long attendenceId, Attendance attendance);
    
    /** 
     * 根据获取签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Attendance getAttendanceByAttendenceId(Long attendenceId);

    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @param attendance 签到信息
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByAttendenceId(Long attendenceId);
    
    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendance2MapListByAttendenceId(Long attendenceId);

    /**
     * 获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceList();
    
    /**
     * 获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendance2MapList();
    
    /**
     * 根据查询条件获取签到个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Integer countAttendanceListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Integer countAttendanceMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendanceMapListByQuery(Map<String, Object> map);
	
}
