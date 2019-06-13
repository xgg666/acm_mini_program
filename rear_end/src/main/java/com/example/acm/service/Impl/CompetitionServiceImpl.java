
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.Competition;
import com.example.acm.mapper.CompetitionMapper;
import com.example.acm.service.CompetitionService;

/** 
 * 比赛服务
 *
 * @author xgg
 * @date 2019-02-18 21:04:49
 */
@Service("competitionService")
@Transactional
public class CompetitionServiceImpl implements CompetitionService {
	
	@Autowired
	private CompetitionMapper  competitionMapper;	
    
    /** 
     * 添加比赛
     * 
     * @param competition 比赛
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void addCompetition(Competition competition){
        competitionMapper.addCompetition(competition);
    }    
    
    /** 
     * 添加比赛列表
     * 
     * @param list 比赛列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void addCompetitionList(List<Competition> list){
        competitionMapper.addCompetitionList(list);
    }
    
    /** 
     * 删除比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void deleteCompetitionByCompetitionId(Long competitionId){
        competitionMapper.deleteCompetitionByCompetitionId(competitionId);
    }
    
    /**
     * 修改比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public void updateCompetitionByCompetitionId(Long competitionId,Competition competition){
        competitionMapper.updateCompetitionByCompetitionId(competitionId,competition);
    }
    
    /** 
     * 根据获取比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Competition getCompetitionByCompetitionId(Long competitionId){
        return competitionMapper.getCompetitionByCompetitionId(competitionId);        
    }
    
    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByCompetitionId(Long competitionId){
        return competitionMapper.findCompetitionListByCompetitionId(competitionId);
    }
    
    /**
     * 查询比赛
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetition2MapListByCompetitionId(Long competitionId){
        return competitionMapper.findCompetition2MapListByCompetitionId(competitionId);
    }

    /**
     * 获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionList(){
        return competitionMapper.findCompetitionList();
    }
    
    /**
     * 获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetition2MapList(){
        return competitionMapper.findCompetition2MapList();
    }
    
    /**
     * 根据查询条件获取比赛个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Integer countCompetitionListByQuery(Map<String, Object> map){
    	return competitionMapper.countCompetitionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Competition> findCompetitionListByQuery(Map<String, Object> map){
    	return competitionMapper.findCompetitionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public Integer countCompetitionMapListByQuery(Map<String, Object> map){
    	return competitionMapper.countCompetitionMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-18 21:04:49
     */
    public List<Map<String,Object>> findCompetitionMapListByQuery(Map<String, Object> map){
    	return competitionMapper.findCompetitionMapListByQuery(map);
    }


    public List<Map<String, Object>> findCompetitionMapListByUser(Map<String, Object> map) {
        return competitionMapper.findCompetitionMapListByUser(map);
    }
}
