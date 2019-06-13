package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.Announcement;

/** 
 * 公告表服务接口
 *
 * @author xgg
 * @date 2019-01-13 16:42:52
 */
public interface AnnouncementService{
    
    /** 
     * 添加公告表
     * 
     * @param announcement 公告表
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void addAnnouncement(Announcement announcement);
    
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
    public void deleteAnnouncementByAnnounceId(Long announceId);
    
    /**
     * 修改公告表
     * 
     * @param announceId  
     * @param announcement 公告表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void updateAnnouncementByAnnounceId(Long announceId, Announcement announcement);
    
    /** 
     * 根据获取公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Announcement getAnnouncementByAnnounceId(Long announceId);

    /**
     * 查询公告表
     * 
     * @param announceId  
     * @param announcement 公告表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByAnnounceId(Long announceId);
    
    /**
     * 查询公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncement2MapListByAnnounceId(Long announceId);

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
    public Integer countAnnouncementListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Integer countAnnouncementMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取公告表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncementMapListByQuery(Map<String, Object> map);
	
}
