
package com.example.acm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.acm.entity.News;

/** 
 * 新闻表数据操作接口
 *
 * @author xgg
 * @date 2019-01-19 21:49:28
 */
public interface NewsMapper{
    
    /** 
     * 添加新闻表
     * 
     * @param news 新闻表
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void addNews(@Param("news") News news);
    
    /** 
     * 添加新闻表列表
     * 
     * @param list 新闻表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void addNewsList(List<News> list);       
    
    /** 
     * 删除新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void deleteNewsByNewsId(@Param("newsId") Long newsId);
    
    /**
     * 修改新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void updateNewsByNewsId(@Param("newsId") Long newsId, @Param("news") News news);
    
    /** 
     * 根据获取新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public News getNewsByNewsId(@Param("newsId") Long newsId);
    
    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByNewsId(@Param("newsId") Long newsId);
    
    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNews2MapListByNewsId(@Param("newsId") Long newsId);

    /**
     * 获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsList();
    
    /**
     * 获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNews2MapList();
    
    /**
     * 根据查询条件获取新闻表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public Integer countNewsListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public Integer countNewsMapListByQuery(@Param("map") Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNewsMapListByQuery(@Param("map") Map<String, Object> map);
	
}
