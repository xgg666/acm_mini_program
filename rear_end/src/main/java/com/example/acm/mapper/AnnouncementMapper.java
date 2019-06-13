
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.Announcement;

/** 
 * 公告表数据操作接口
 *
 * @author xgg
 * @date 2019-01-13 16:42:52
 */
public interface AnnouncementMapper{
    
    /** 
     * 添加公告表
     * 
     * @param announcement 公告表
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void addAnnouncement(@Param("announcement") Announcement announcement);
    
    /** 
     * 添加公告表列表
     * 
     * @param list 公告表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void addAnnouncementList(List<Announcement> list);       
    
    /** 
     * 删除公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void deleteAnnouncementByAnnounceId(@Param("announceId") Long announceId);
    
    /**
     * 修改公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void updateAnnouncementByAnnounceId(@Param("announceId") Long announceId, @Param("announcement") Announcement announcement);
    
    /** 
     * 根据获取公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Announcement getAnnouncementByAnnounceId(@Param("announceId") Long announceId);
    
    /**
     * 查询公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByAnnounceId(@Param("announceId") Long announceId);
    
    /**
     * 查询公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncement2MapListByAnnounceId(@Param("announceId") Long announceId);

    /**
     * 获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementList();
    
    /**
     * 获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncement2MapList();
    
    /**
     * 根据查询条件获取公告表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Integer countAnnouncementListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Integer countAnnouncementMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncementMapListByQuery(@Param("map") Map<String, Object> map);
	
}
