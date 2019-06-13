
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 公告表实体
 * 
 * @author yxk
 * @date 2019-01-13 16:56:33
 */
public class Announcement implements Serializable {

    private Long announceId;//
    private String announceTitle;//
    private Object announceBody;//
    private Long announceCreateUser;//
    private Date announceCreateTime;//
    private Long announceUpdateUser;//
    private Date announceUpdateTime;//
    private Integer isEffective;//
    private Integer isFirst;//
    private Integer isPublic;//

	public void setAnnounceId(Long announceId) {
		this.announceId = announceId;
	}
	public Long getAnnounceId() {
		return this.announceId;
	}
	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
	}
	public String getAnnounceTitle() {
		return this.announceTitle;
	}
	public void setAnnounceBody(Object announceBody) {
		this.announceBody = announceBody;
	}
	public Object getAnnounceBody() {
		return this.announceBody;
	}
	public void setAnnounceCreateUser(Long announceCreateUser) {
		this.announceCreateUser = announceCreateUser;
	}
	public Long getAnnounceCreateUser() {
		return this.announceCreateUser;
	}
	public void setAnnounceCreateTime(Date announceCreateTime) {
		this.announceCreateTime = announceCreateTime;
	}
	public Date getAnnounceCreateTime() {
		return this.announceCreateTime;
	}
	public void setAnnounceUpdateUser(Long announceUpdateUser) {
		this.announceUpdateUser = announceUpdateUser;
	}
	public Long getAnnounceUpdateUser() {
		return this.announceUpdateUser;
	}
	public void setAnnounceUpdateTime(Date announceUpdateTime) {
		this.announceUpdateTime = announceUpdateTime;
	}
	public Date getAnnounceUpdateTime() {
		return this.announceUpdateTime;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
	public void setIsFirst(Integer isFirst) {
		this.isFirst = isFirst;
	}
	public Integer getIsFirst() {
		return this.isFirst;
	}
	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}
	public Integer getIsPublic() {
		return this.isPublic;
	}
}

