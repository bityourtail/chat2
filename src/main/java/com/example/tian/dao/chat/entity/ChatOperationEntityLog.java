package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatOperationEntityLog {
    private Long id;

    private String userId;

    private Integer type;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public ChatOperationEntityLog(Long id, String userId, Integer type, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public ChatOperationEntityLog() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}