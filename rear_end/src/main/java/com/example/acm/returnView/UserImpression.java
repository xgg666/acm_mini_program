package com.example.acm.returnView;

import com.example.acm.entity.Impression;

import java.util.Date;
import java.util.List;

/**
 * Created by xgg on 2019/4/11.
 */
public class UserImpression {
    private Integer auth;// 0-未通过审核 1-超级管理员 2-管理员 3-队员 4-萌新 5-未完善资料的萌新
    private Integer classNum;//
    private Date createDay;//
    private Integer grade;//
    private String image;//
    private String mobile;//
    private String openId;//
    private String password;//
    private String realname;//
    private Long studentId;//
    private Integer userId;//
    private String username;//手机号
    private String unionid;//
    private List<Impression> impressionList;

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
    public Integer getAuth() {
        return this.auth;
    }
    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }
    public Integer getClassNum() {
        return this.classNum;
    }
    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }
    public Date getCreateDay() {
        return this.createDay;
    }
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
    public Integer getGrade() {
        return this.grade;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public String getOpenId() {
        return this.openId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getRealname() {
        return this.realname;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return this.userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setImpressionList(List<Impression> impressionList) {
        this.impressionList = impressionList;
    }

    public List<Impression> getImpressionList() {
        return impressionList;
    }


}
