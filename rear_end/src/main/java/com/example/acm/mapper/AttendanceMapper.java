
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.Attendance;

/** 
 * 签到数据操作接口
 *
 * @author xgg
 * @date 2019-03-29 17:03:29
 */
public interface AttendanceMapper{
    
    /** 
     * 添加签到
     * 
     * @param attendance 签到
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void addAttendance(@Param("attendance") Attendance attendance);
    
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
    public void deleteAttendanceByAttendenceId(@Param("attendenceId") Long attendenceId);
    
    /**
     * 修改签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public void updateAttendanceByAttendenceId(@Param("attendenceId") Long attendenceId, @Param("attendance") Attendance attendance);
    
    /** 
     * 根据获取签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Attendance getAttendanceByAttendenceId(@Param("attendenceId") Long attendenceId);
    
    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByAttendenceId(@Param("attendenceId") Long attendenceId);
    
    /**
     * 查询签到
     * 
     * @param attendenceId  
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendance2MapListByAttendenceId(@Param("attendenceId") Long attendenceId);

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
    public Integer countAttendanceListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Attendance> findAttendanceListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public Integer countAttendanceMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取签到列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-03-29 17:03:29
     */
    public List<Map<String,Object>> findAttendanceMapListByQuery(@Param("map") Map<String, Object> map);
	
}
