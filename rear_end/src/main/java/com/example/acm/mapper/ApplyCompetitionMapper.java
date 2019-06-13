
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.ApplyCompetition;

/** 
 * 比赛报名数据操作接口
 *
 * @author xgg
 * @date 2019-02-19 22:49:11
 */
public interface ApplyCompetitionMapper{
    
    /** 
     * 添加比赛报名
     * 
     * @param applyCompetition 比赛报名
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void addApplyCompetition(@Param("applyCompetition") ApplyCompetition applyCompetition);
    
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
    public void deleteApplyCompetitionByApplyCompetitionId(@Param("applyCompetitionId") Long applyCompetitionId);
    
    /**
     * 修改比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void updateApplyCompetitionByApplyCompetitionId(@Param("applyCompetitionId") Long applyCompetitionId, @Param("applyCompetition") ApplyCompetition applyCompetition);
    
    /** 
     * 根据获取比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public ApplyCompetition getApplyCompetitionByApplyCompetitionId(@Param("applyCompetitionId") Long applyCompetitionId);
    
    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByApplyCompetitionId(@Param("applyCompetitionId") Long applyCompetitionId);
    
    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByCompetitionId(@Param("competitionId") Long competitionId);

    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByApplyCompetitionId(@Param("applyCompetitionId") Long applyCompetitionId);

    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByCompetitionId(@Param("competitionId") Long competitionId);

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
    public Integer countApplyCompetitionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public Integer countApplyCompetitionMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取比赛报名列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetitionMapListByQuery(@Param("map") Map<String, Object> map);
	
}
