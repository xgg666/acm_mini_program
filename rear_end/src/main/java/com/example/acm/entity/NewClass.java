
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 新闻_类表实体
 * 
 * @author xgg
 * @date 2019-01-22 22:47:10
 */
public class NewClass implements Serializable {

    private Long newClassId;//
    private Long newsId;//
    private Long classId;//
    private Long createUser;//
    private Date createDate;//
    private Long updateUser;//
    private Date updateDate;//
    private Integer isEffective;//

	public void setNewClassId(Long newClassId) {
		this.newClassId = newClassId;
	}
	public Long getNewClassId() {
		return this.newClassId;
	}
	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}
	public Long getNewsId() {
		return this.newsId;
	}
	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getClassId() {
		return this.classId;
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
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
}

