package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatTalkMessage {
    private Long id;

    private String senderUserId;

    private String receiverUserId;

    private Integer msgType;

    private String content;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public ChatTalkMessage(Long id, String senderUserId, String receiverUserId, Integer msgType, String content, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.msgType = msgType;
        this.content = content;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public ChatTalkMessage() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(String senderUserId) {
        this.senderUserId = senderUserId == null ? null : senderUserId.trim();
    }

    public String getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(String receiverUserId) {
        this.receiverUserId = receiverUserId == null ? null : receiverUserId.trim();
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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