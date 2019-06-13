
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.ApplyCompetition;

/** 
 * 比赛报名服务接口
 *
 * @author xgg
 * @date 2019-02-19 22:49:11
 */
public interface ApplyCompetitionService{
    
    /** 
     * 添加比赛报名
     * 
     * @param applyCompetition 比赛报名
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void addApplyCompetition(ApplyCompetition applyCompetition);
    
    /** 
     * 添加比赛报名列表
     * 
     * @param list 比赛报名列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void addApplyCompetitionList(List<ApplyCompetition> list);      
    
    /** 
     * 删除比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void deleteApplyCompetitionByApplyCompetitionId(Long applyCompetitionId);
    
    /**
     * 修改比赛报名
     * 
     * @param applyCompetitionId  
     * @param applyCompetition 比赛报名信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void updateApplyCompetitionByApplyCompetitionId(Long applyCompetitionId, ApplyCompetition applyCompetition);
    
    /** 
     * 根据获取比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public ApplyCompetition getApplyCompetitionByApplyCompetitionId(Long applyCompetitionId);

    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @param applyCompetition 比赛报名信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByApplyCompetitionId(Long applyCompetitionId);
    
    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByCompetitionId(Long competitionId);

    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByApplyCompetitionId(Long applyCompetitionId);

    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByCompetitionId(Long competitionId);

    /**
     * 获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionList();
    
    /**
     * 获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapList();
    
    /**
     * 根据查询条件获取比赛报名个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public Integer countApplyCompetitionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public Integer countApplyCompetitionMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetitionMapListByQuery(Map<String, Object> map);
	
}
