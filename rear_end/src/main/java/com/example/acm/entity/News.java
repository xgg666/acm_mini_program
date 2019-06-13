
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 新闻表实体
 * 
 * @author xgg
 * @date 2019-01-19 21:54:01
 */
public class News implements Serializable {

    private Long newsId;//
    private String newsTitle;//
    private Object newsBody;//
    private Long createUser;//
    private Date createDate;//
    private Long updateUser;//
    private Date updateDate;//
    private Integer isPublic;//
    private Integer isEffective;//

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
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}
	public Long getUpdateUser() {
		return this.updateUser;
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

