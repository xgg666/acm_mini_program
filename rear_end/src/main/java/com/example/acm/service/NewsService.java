
package com.example.acm.service;

import java.util.List;
import java.util.Map;

import com.example.acm.entity.News;

/** 
 * 新闻表服务接口
 *
 * @author xgg
 * @date 2019-01-19 21:49:28
 */
public interface NewsService{
    
    /** 
     * 添加新闻表
     * 
     * @param news 新闻表
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void addNews(News news);
    
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
    public void deleteNewsByNewsId(Long newsId);
    
    /**
     * 修改新闻表
     * 
     * @param newsId  
     * @param news 新闻表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void updateNewsByNewsId(Long newsId, News news);
    
    /** 
     * 根据获取新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public News getNewsByNewsId(Long newsId);

    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @param news 新闻表信息
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByNewsId(Long newsId);
    
    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNews2MapListByNewsId(Long newsId);

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
    public Integer countNewsListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public Integer countNewsMapListByQuery(Map<String, Object> map);
    
    /**
     * 根据查询条件获取新闻表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNewsMapListByQuery(Map<String, Object> map);
	
}
