package com.example.acm.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Classification implements Serializable {

    private Long classId;//
    private String className;//
    private Integer isEffective;//
    private Date updateTime;//
    private Date createTime;//
    private Long createBy;//

	public void setClassId(Long classId) {
		this.classId = classId;
	}
	public Long getClassId() {
		return this.classId;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassName() {
		return this.className;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getUpdateTime() {
		return this.updateTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Long getCreateBy() {
		return this.createBy;
	}
}

