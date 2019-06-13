
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.Competition;

/** 
 * 比赛数据操作接口
 *
 * @author xgg
 * @date 2019-02-18 21:04:49
 */
public interface CompetitionMapper{
    
    /** 
     * 添加比赛
     * 
     * @param competition 比赛
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void addCompetition(@Param("competition") Competition competition);
    
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
    public void deleteCompetitionByCompetitionId(@Param("competitionId") Long competitionId);
    
    /**
     * 修改比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void updateCompetitionByCompetitionId(@Param("competitionId") Long competitionId, @Param("competition") Competition competition);
    
    /** 
     * 根据获取比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Competition getCompetitionByCompetitionId(@Param("competitionId") Long competitionId);
    
    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByCompetitionId(@Param("competitionId") Long competitionId);
    
    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetition2MapListByCompetitionId(@Param("competitionId") Long competitionId);

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
    public Integer countCompetitionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Integer countCompetitionMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetitionMapListByQuery(@Param("map") Map<String, Object> map);

    public List<Map<String, Object>> findCompetitionMapListByUser(@Param("map") Map<String, Object> map);
}
