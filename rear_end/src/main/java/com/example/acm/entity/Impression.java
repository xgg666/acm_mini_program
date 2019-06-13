
package com.example.acm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 印象实体
 * 
 * @author xgg
 * @date 2019-04-11 11:54:19
 */
public class Impression implements Serializable {

    private Long impressionId;//
    private String impressionTitle;//
    private Integer imUser;//被评论用户
    private Integer createUser;//
    private Date createDate;//
    private Integer agreeNum;//
    private Integer isEffective;//

	public void setImpressionId(Long impressionId) {
		this.impressionId = impressionId;
	}
	public Long getImpressionId() {
		return this.impressionId;
	}
	public void setImpressionTitle(String impressionTitle) {
		this.impressionTitle = impressionTitle;
	}
	public String getImpressionTitle() {
		return this.impressionTitle;
	}
	public void setImUser(Integer imUser) {
		this.imUser = imUser;
	}
	public Integer getImUser() {
		return this.imUser;
	}
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	public Integer getCreateUser() {
		return this.createUser;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setAgreeNum(Integer agreeNum) {
		this.agreeNum = agreeNum;
	}
	public Integer getAgreeNum() {
		return this.agreeNum;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getIsEffective() {
		return this.isEffective;
	}
}

