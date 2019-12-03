package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatUserInfo {
    private Long id;

    private String userId;

    private Integer sex;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    private Integer status;

    public ChatUserInfo(Long id, String userId, Integer sex, Date dbCreateTime, Date dbUpdateTime, Integer status) {
        this.id = id;
        this.userId = userId;
        this.sex = sex;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
        this.status = status;
    }

    public ChatUserInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getDbCreateTime() {
        return dbCreateTime;
    }

    public void setDbCreateTime(Date dbCreateTime) {
        this.dbCreateTime = dbCreateTime;
    }

    public Date getDbUpdateTime() {
        return dbUpdateTime;
    }

    public void setDbUpdateTime(Date dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}