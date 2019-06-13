package com.example.acm.view;

import com.example.acm.entity.Classification;
import com.example.acm.entity.News;
import com.example.acm.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by xgg on 2019/1/23.
 */
public class NewsView {
    private Long newsId;//
    private String newsTitle;//
    private Object newsBody;//
    private Long createUser;//
    private Date createDate;//
    private Long updateUser;//
    private Date updateDate;//
    private Integer isPublic;//
    private Integer isEffective;//
    List<Classification> classifications;

    public NewsView(News news, List<Classification> classifications) {
        this.newsId = news.getNewsId();
        this.newsTitle = news.getNewsTitle();
        this.newsBody = news.getNewsBody();
        this.createUser = news.getCreateUser();
        this.createDate = news.getCreateDate();
        this.updateUser = news.getUpdateUser();
        this.updateDate = news.getUpdateDate();
        this.isPublic = news.getIsPublic();
        this.isEffective = news.getIsEffective();
        this.classifications = classifications;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }
    public Long getNewsId() {
        return this.newsId;
    }
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
    public String getNewsTitle() {
        return this.newsTitle;
    }
    public void setNewsBody(Object newsBody) {
        this.newsBody = newsBody;
    }
    public Object getNewsBody() {
        return this.newsBody;
    }
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }
    public Long getCreateUser() {
        return this.createUser;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public String getCreateDate() {
        return DateUtils.convDateToStr(this.createDate, "yyyy-MM-dd HH:mm:ss");
        //return this.createDate;
    }
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
    public String getUpdateUser() {
        return DateUtils.convDateToStr(this.updateDate, "yyyy-MM-dd HH:mm:ss");
     //   return this.updateUser;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }
    public Integer getIsPublic() {
        return this.isPublic;
    }
    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
    }
    public Integer getIsEffective() {
        return this.isEffective;
    }
}
