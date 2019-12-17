package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatMessage {
    private Long id;

    private String content;

    private String userId;

    private Integer getTimes;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public ChatMessage(Long id, String content, String userId, Integer getTimes, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.getTimes = getTimes;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public ChatMessage() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getGetTimes() {
        return getTimes;
    }

    public void setGetTimes(Integer getTimes) {
        this.getTimes = getTimes;
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