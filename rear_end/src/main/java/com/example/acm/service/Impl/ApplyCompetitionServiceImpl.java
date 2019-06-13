
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.ApplyCompetition;
import com.example.acm.mapper.ApplyCompetitionMapper;
import com.example.acm.service.ApplyCompetitionService;

/** 
 * 比赛报名服务
 *
 * @author xgg
 * @date 2019-02-19 22:49:11
 */
@Service("applyCompetitionService")
@Transactional
public class ApplyCompetitionServiceImpl implements ApplyCompetitionService {
	
	@Autowired
	private ApplyCompetitionMapper  applyCompetitionMapper;	
    
    /** 
     * 添加比赛报名
     * 
     * @param applyCompetition 比赛报名
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void addApplyCompetition(ApplyCompetition applyCompetition){
        applyCompetitionMapper.addApplyCompetition(applyCompetition);
    }    
    
    /** 
     * 添加比赛报名列表
     * 
     * @param list 比赛报名列表
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void addApplyCompetitionList(List<ApplyCompetition> list){
        applyCompetitionMapper.addApplyCompetitionList(list);
    }
    
    /** 
     * 删除比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void deleteApplyCompetitionByApplyCompetitionId(Long applyCompetitionId){
        applyCompetitionMapper.deleteApplyCompetitionByApplyCompetitionId(applyCompetitionId);
    }
    
    /**
     * 修改比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public void updateApplyCompetitionByApplyCompetitionId(Long applyCompetitionId,ApplyCompetition applyCompetition){
        applyCompetitionMapper.updateApplyCompetitionByApplyCompetitionId(applyCompetitionId,applyCompetition);
    }
    
    /** 
     * 根据获取比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public ApplyCompetition getApplyCompetitionByApplyCompetitionId(Long applyCompetitionId){
        return applyCompetitionMapper.getApplyCompetitionByApplyCompetitionId(applyCompetitionId);        
    }
    
    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByApplyCompetitionId(Long applyCompetitionId){
        return applyCompetitionMapper.findApplyCompetitionListByApplyCompetitionId(applyCompetitionId);
    }
    
    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByCompetitionId(Long competitionId){
        return applyCompetitionMapper.findApplyCompetitionListByCompetitionId(competitionId);
    }

    /**
     * 查询比赛报名
     * 
     * @param applyCompetitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByApplyCompetitionId(Long applyCompetitionId){
        return applyCompetitionMapper.findApplyCompetition2MapListByApplyCompetitionId(applyCompetitionId);
    }

    /**
     * 查询比赛报名
     * 
     * @param competitionId  
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapListByCompetitionId(Long competitionId){
        return applyCompetitionMapper.findApplyCompetition2MapListByCompetitionId(competitionId);
    }

    /**
     * 获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionList(){
        return applyCompetitionMapper.findApplyCompetitionList();
    }
    
    /**
     * 获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetition2MapList(){
        return applyCompetitionMapper.findApplyCompetition2MapList();
    }
    
    /**
     * 根据查询条件获取比赛报名个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public Integer countApplyCompetitionListByQuery(Map<String, Object> map){
    	return applyCompetitionMapper.countApplyCompetitionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛报名列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<ApplyCompetition> findApplyCompetitionListByQuery(Map<String, Object> map){
    	return applyCompetitionMapper.findApplyCompetitionListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛报名个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public Integer countApplyCompetitionMapListByQuery(Map<String, Object> map){
    	return applyCompetitionMapper.countApplyCompetitionMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取比赛报名列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-02-19 22:49:11
     */
    public List<Map<String,Object>> findApplyCompetitionMapListByQuery(Map<String, Object> map){
    	return applyCompetitionMapper.findApplyCompetitionMapListByQuery(map);
    }

}
