package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatGetMessage {
    private Long id;

    private String userId;

    private Long msgId;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public ChatGetMessage(Long id, String userId, Long msgId, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.userId = userId;
        this.msgId = msgId;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public ChatGetMessage() {
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

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
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