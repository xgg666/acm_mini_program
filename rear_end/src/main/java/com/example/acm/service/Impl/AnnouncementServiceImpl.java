package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.Announcement;
import com.example.acm.mapper.AnnouncementMapper;
import com.example.acm.service.AnnouncementService;

/** 
 * 公告表服务
 *
 * @author xgg
 * @date 2019-01-13 16:42:52
 */
@Service("announcementService")
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementMapper  announcementMapper;	
    
    /** 
     * 添加公告表
     * 
     * @param announcement 公告表
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void addAnnouncement(Announcement announcement){
        announcementMapper.addAnnouncement(announcement);
    }    
    
    /** 
     * 添加公告表列表
     * 
     * @param list 公告表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void addAnnouncementList(List<Announcement> list){
        announcementMapper.addAnnouncementList(list);
    }
    
    /** 
     * 删除公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void deleteAnnouncementByAnnounceId(Long announceId){
        announcementMapper.deleteAnnouncementByAnnounceId(announceId);
    }
    
    /**
     * 修改公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public void updateAnnouncementByAnnounceId(Long announceId,Announcement announcement){
        announcementMapper.updateAnnouncementByAnnounceId(announceId,announcement);
    }
    
    /** 
     * 根据获取公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Announcement getAnnouncementByAnnounceId(Long announceId){
        return announcementMapper.getAnnouncementByAnnounceId(announceId);        
    }
    
    /**
     * 查询公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByAnnounceId(Long announceId){
        return announcementMapper.findAnnouncementListByAnnounceId(announceId);
    }
    
    /**
     * 查询公告表
     * 
     * @param announceId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncement2MapListByAnnounceId(Long announceId){
        return announcementMapper.findAnnouncement2MapListByAnnounceId(announceId);
    }

    /**
     * 获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementList(){
        return announcementMapper.findAnnouncementList();
    }
    
    /**
     * 获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncement2MapList(){
        return announcementMapper.findAnnouncement2MapList();
    }
    
    /**
     * 根据查询条件获取公告表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Integer countAnnouncementListByQuery(Map<String, Object> map){
    	return announcementMapper.countAnnouncementListByQuery(map);
    }
    
    /**
     * 根据查询条件获取公告表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Announcement> findAnnouncementListByQuery(Map<String, Object> map){
    	return announcementMapper.findAnnouncementListByQuery(map);
    }
    
    /**
     * 根据查询条件获取公告表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public Integer countAnnouncementMapListByQuery(Map<String, Object> map){
    	return announcementMapper.countAnnouncementMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取公告表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-13 16:42:52
     */
    public List<Map<String,Object>> findAnnouncementMapListByQuery(Map<String, Object> map){
    	return announcementMapper.findAnnouncementMapListByQuery(map);
    }

}
