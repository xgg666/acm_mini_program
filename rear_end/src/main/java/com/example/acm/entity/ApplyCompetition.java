
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 比赛报名实体
 * 
 * @author xgg
 * @date 2019-02-19 22:49:11
 */
public class ApplyCompetition implements Serializable {

    private Long applyCompetitionId;//
    private Long competitionId;//
    private Integer joinUser;//
    private Date createDate;//
    private Integer isEffective;//

	public void setApplyCompetitionId(Long applyCompetitionId) {
		this.applyCompetitionId = applyCompetitionId;
	}
	public Long getApplyCompetitionId() {
		return this.applyCompetitionId;
	}
	public void setCompetitionId(Long competitionId) {
		this.competitionId = competitionId;
	}
	public Long getCompetitionId() {
		return this.competitionId;
	}
	public void setJoinUser(Integer joinUser) {
		this.joinUser = joinUser;
	}
	public Integer getJoinUser() {
		return this.joinUser;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
}

