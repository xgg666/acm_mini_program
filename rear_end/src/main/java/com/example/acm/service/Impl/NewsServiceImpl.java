
package com.example.acm.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.acm.entity.News;
import com.example.acm.mapper.NewsMapper;
import com.example.acm.service.NewsService;

/** 
 * 新闻表服务
 *
 * @author xgg
 * @date 2019-01-19 21:49:28
 */
@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsMapper  newsMapper;	
    
    /** 
     * 添加新闻表
     * 
     * @param news 新闻表
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void addNews(News news){
        newsMapper.addNews(news);
    }    
    
    /** 
     * 添加新闻表列表
     * 
     * @param list 新闻表列表
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void addNewsList(List<News> list){
        newsMapper.addNewsList(list);
    }
    
    /** 
     * 删除新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void deleteNewsByNewsId(Long newsId){
        newsMapper.deleteNewsByNewsId(newsId);
    }
    
    /**
     * 修改新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public void updateNewsByNewsId(Long newsId,News news){
        newsMapper.updateNewsByNewsId(newsId,news);
    }
    
    /** 
     * 根据获取新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public News getNewsByNewsId(Long newsId){
        return newsMapper.getNewsByNewsId(newsId);        
    }
    
    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByNewsId(Long newsId){
        return newsMapper.findNewsListByNewsId(newsId);
    }
    
    /**
     * 查询新闻表
     * 
     * @param newsId  
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNews2MapListByNewsId(Long newsId){
        return newsMapper.findNews2MapListByNewsId(newsId);
    }

    /**
     * 获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsList(){
        return newsMapper.findNewsList();
    }
    
    /**
     * 获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNews2MapList(){
        return newsMapper.findNews2MapList();
    }
    
    /**
     * 根据查询条件获取新闻表个数
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public Integer countNewsListByQuery(Map<String, Object> map){
    	return newsMapper.countNewsListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻表列表
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<News> findNewsListByQuery(Map<String, Object> map){
    	return newsMapper.findNewsListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻表个数(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public Integer countNewsMapListByQuery(Map<String, Object> map){
    	return newsMapper.countNewsMapListByQuery(map);
    }
    
    /**
     * 根据查询条件获取新闻表列表(Map)
     * 
     * @version v1.0
     * @author xgg
     * @date 2019-01-19 21:49:28
     */
    public List<Map<String,Object>> findNewsMapListByQuery(Map<String, Object> map){
    	return newsMapper.findNewsMapListByQuery(map);
    }

}
