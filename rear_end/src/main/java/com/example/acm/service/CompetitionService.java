
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.Competition;
import org.apache.ibatis.annotations.Param;

/** 
 * 比赛服务接口
 *
 * @author xgg
 * @date 2019-02-18 21:04:49
 */
public interface CompetitionService{
    
    /** 
     * 添加比赛
     * 
     * @param competition 比赛
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void addCompetition(Competition competition);
    
    /** 
     * 添加比赛列表
     * 
     * @param list 比赛列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void addCompetitionList(List<Competition> list);      
    
    /** 
     * 删除比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void deleteCompetitionByCompetitionId(Long competitionId);
    
    /**
     * 修改比赛
     * 
     * @param competitionId  
     * @param competition 比赛信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void updateCompetitionByCompetitionId(Long competitionId, Competition competition);
    
    /** 
     * 根据获取比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Competition getCompetitionByCompetitionId(Long competitionId);

    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @param competition 比赛信息
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByCompetitionId(Long competitionId);
    
    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetition2MapListByCompetitionId(Long competitionId);

    /**
     * 获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionList();
    
    /**
     * 获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetition2MapList();
    
    /**
     * 根据查询条件获取比赛个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Integer countCompetitionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Integer countCompetitionMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetitionMapListByQuery(Map<String, Object> map);

    public List<Map<String, Object>> findCompetitionMapListByUser(Map<String, Object> map);
}
