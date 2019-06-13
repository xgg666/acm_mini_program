
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 比赛实体
 * 
 * @author xgg
 * @date 2019-02-19 21:39:56
 */
public class Competition implements Serializable {

    private Long competitionId;//
    private String competitionTitle;//
    private Object competitionBody;//
    private Date createDate;//
    private Integer createUser;//
    private Date updateDate;//
    private Integer updateUser;//
    private Integer isDone;//
    private Integer isEffective;//
	private Date BeginDate;//
	private Date UntilDate;//

	public void setCompetitionId(Long competitionId) {
		this.competitionId = competitionId;
	}
	public Long getCompetitionId() {
		return this.competitionId;
	}
	public void setCompetitionTitle(String competitionTitle) {
		this.competitionTitle = competitionTitle;
	}
	public String getCompetitionTitle() {
		return this.competitionTitle;
	}
	public void setCompetitionBody(Object competitionBody) {
		this.competitionBody = competitionBody;
	}
	public Object getCompetitionBody() {
		return this.competitionBody;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getUpdateDate() {
		return this.updateDate;
	}
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}
	public Integer getUpdateUser() {
		return this.updateUser;
	}
	public void setIsDone(Integer isDone) {
		this.isDone = isDone;
	}
	public Integer getIsDone() {
		return this.isDone;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
	public Date getBeginDate() {
		return BeginDate;
	}
	public void setBeginDate(Date beginDate) {
		BeginDate = beginDate;
	}
	public Date getUntilDate() {
		return UntilDate;
	}
	public void setUntilDate(Date untilDate) {
		UntilDate = untilDate;
	}
}

