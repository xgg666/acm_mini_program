package com.example.acm.service.deal.Impl;

import com.example.acm.common.ResultBean;
import com.example.acm.common.ResultCode;
import com.example.acm.entity.Classification;
import com.example.acm.entity.NewClass;
import com.example.acm.entity.News;
import com.example.acm.entity.User;
import com.example.acm.service.ClassificationService;
import com.example.acm.service.NewClassService;
import com.example.acm.service.NewsService;
import com.example.acm.service.UserService;
import com.example.acm.service.deal.NewsDealService;
import com.example.acm.utils.DateUtils;
import com.example.acm.utils.ListPage;
import com.example.acm.utils.UUIDUtil;
import com.example.acm.view.NewsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by xgg on 2019/1/19.
 */
@Service
public class NewsDealImpl implements NewsDealService{

    private static final Logger LOG = LoggerFactory.getLogger(NewsDealImpl.class);

    @Autowired
    public NewsService newsService;
    @Autowired
    public UserService userService;
    @Autowired
    public NewClassService newClassService;
    @Autowired
    public ClassificationService classificationService;

    public ResultBean addNews(User user, String newsTitle, String newsBody, int isPublic, String classType){
        try {
            News news = new News();
            Long bigInteger = new Long(UUIDUtil.getNumUUID());
            news.setNewsId(bigInteger);
            news.setNewsTitle(newsTitle);
            news.setNewsBody(newsBody);
            news.setIsPublic(isPublic);
            news.setCreateUser(user.getUserId().longValue());
            news.setCreateDate(new Date());
            news.setUpdateUser(user.getUserId().longValue());
            news.setUpdateDate(new Date());
            news.setIsEffective(1);
            System.out.println("news body before: " + news.getNewsBody());
            newsService.addNews(news);
            System.out.println("news body after: " + news.getNewsBody());

            if(classType.length()==0) {
                Map<String, Object> map = new HashMap<>();
                map.put("className", "未分类");
                List<Classification> list = classificationService.findClassificationListByQuery(map);
                if (list.size()==0) {
                    return new ResultBean(ResultCode.SYSTEM_FAILED, "不存在'未分类'这一分类");
                }
                long num = list.get(0).getClassId();
                classType = num+"";
            }
            String classA[] = classType.split(",");

            for(int i=0; i<classA.length; i++) {
                NewClass newClass = new NewClass();
                newClass.setClassId(new Long(classA[i]));
                newClass.setNewsId(bigInteger);
                newClass.setCreateUser(user.getUserId().longValue());
                newClass.setCreateDate(new Date());
                newClass.setUpdateUser(user.getUserId().longValue());
                newClass.setUpdateDate(new Date());
                newClass.setIsEffective(1);

                newClassService.addNewClass(newClass);
            }

            return new ResultBean(ResultCode.SUCCESS, bigInteger);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }


    public ResultBean updateNews(User user, long newsId, String newsTitle, String newsBody, int isPublic, String classType){
        try {
            List<News> news = newsService.findNewsListByNewsId(newsId);
            if (news.size()==0) {
                LOG.info("该id新闻不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该新闻");
            }

            News newU = news.get(0);
            newU.setNewsTitle(newsTitle);
            newU.setNewsBody(newsBody);
            newU.setIsPublic(isPublic);
            newU.setUpdateDate(new Date());
            newU.setUpdateUser(user.getUserId().longValue());

            if(classType.length()==0) {
                Map<String, Object> map = new HashMap<>();
                map.put("className", "未分类");
                List<Classification> list = classificationService.findClassificationListByQuery(map);
                if (list.size()==0) {
                    return new ResultBean(ResultCode.SYSTEM_FAILED, "不存在'未分类'这一分类");
                }
                long num = list.get(0).getClassId();
                classType = num+"";
            }
            String classA[] = classType.split(",");

            if(classA.length>3) {
                return new ResultBean(ResultCode.PARAM_ERROR, "最多选择三个分类");
            }
            Map<String, Object> mapNew = new HashMap<>();
            mapNew.put("newsId", newU.getNewsId());
            mapNew.put("isEffective", 1);
            List<NewClass> classes = newClassService.findNewClassListByQuery(mapNew);
            List<BigInteger> listNum = new ArrayList<>();
            for(int i=0; i<classes.size(); i++) {
                listNum.add(new BigInteger(classes.get(i).getClassId().toString()));
            }
            for(int i=0; i<classA.length; i++) {
                if (listNum.contains(new BigInteger(classA[i]))) {
                    listNum.remove(new BigInteger(classA[i]));
                    continue;
                }
                NewClass newClass = new NewClass();
                newClass.setClassId(new Long(classA[i]));
                newClass.setNewsId(newU.getNewsId());
                newClass.setCreateUser(user.getUserId().longValue());
                newClass.setCreateDate(new Date());
                newClass.setUpdateUser(user.getUserId().longValue());
                newClass.setUpdateDate(new Date());
                newClass.setIsEffective(1);

                newClassService.addNewClass(newClass);
            }
            for (int i=0; i<classes.size(); i++) {
                if (listNum.contains(new BigInteger(classes.get(i).getClassId().toString()))) {
                    NewClass tmp = classes.get(i);
                    tmp.setIsEffective(0);
                    tmp.setUpdateUser(user.getUserId().longValue());
                    tmp.setUpdateDate(new Date());
                    newClassService.updateNewClassByNewClassId(tmp.getNewClassId(), tmp);
                }
            }
            newsService.updateNewsByNewsId(newsId, newU);

            return new ResultBean(ResultCode.SUCCESS, newU.getNewsId());
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }

    public ResultBean deleteNews(User user, long newsId){
        try {
            List<News> news = newsService.findNewsListByNewsId(newsId);
            if (news.size()==0) {
                LOG.info("该id新闻不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该新闻");
            }

            News newU = news.get(0);
            newU.setUpdateDate(new Date());
            newU.setUpdateUser(user.getUserId().longValue());
            newU.setIsEffective(0);

            newsService.updateNewsByNewsId(newsId, newU);

            return new ResultBean(ResultCode.SUCCESS, newU.getNewsId());
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }


    public ResultBean selectNews(String newsTitle, int aOrs, String order, int pageNum, int pageSize, int isPublic){
        try {

            Map<String, Object> map = new HashMap<>();
            if (pageNum < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "页码不能小于0");
            }
            if (pageSize < 0) {
                return new ResultBean(ResultCode.PARAM_ERROR, "一页展示数量不能小于0");
            }
            int start = (pageNum - 1) * pageSize;
            int limit = pageSize;
            map.put("newsTitle", newsTitle);
            map.put("start", start);
            map.put("limit", limit);
            map.put("order", order);
            if (aOrs == 1) {
                map.put("aOrS", "DESC");
            } else {
                map.put("aOrS", "ASC");
            }
            if (isPublic==1 || isPublic==1) {
                map.put("isPublic", isPublic);
            }
            map.put("isEffective", 1);
            List<Map<String, Object>> list = newsService.findNewsMapListByQuery(map);

            if (list.size() >0) {
                for (Map<String, Object> mapTemp : list) {
                    mapTemp.put("createDate", DateUtils.convDateToStr((Date) mapTemp.get("createDate"), "yyyy-MM-dd HH:mm:ss"));
                    mapTemp.put("updateDate", DateUtils.convDateToStr((Date) mapTemp.get("updateDate"), "yyyy-MM-dd HH:mm:ss"));
                    List<User> users = userService.findUserListByUserId(Integer.parseInt(mapTemp.get("createUser").toString()));
                    mapTemp.put("createUser", users.get(0).getUsername());
                }
            }

            int allNum = newsService.countNewsListByQuery(map);

            ListPage<List<Map<String, Object>>> listPage = ListPage.createListPage(pageNum, pageSize, allNum, list);

            return new ResultBean(ResultCode.SUCCESS, listPage);

        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }


    public ResultBean detail(User user, long newsId){
        try {
            List<News> news = newsService.findNewsListByNewsId(newsId);
            if (news.size()==0) {
                LOG.info("该id新闻不存在");
                return new ResultBean(ResultCode.PARAM_ERROR, "不存在该新闻");
            }
            Map<String, Object> map = new HashMap<>();
            map.put("newsId", newsId);
            map.put("isEffective", 1);

            List<Classification> classifications = classificationService.findNewsClasfication(map);

            NewsView newsView = new NewsView(news.get(0), classifications);
            return new ResultBean(ResultCode.SUCCESS, newsView);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return new ResultBean(ResultCode.SYSTEM_FAILED);
        }
    }
}
