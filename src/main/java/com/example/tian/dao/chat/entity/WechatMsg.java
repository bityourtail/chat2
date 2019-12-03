package com.example.tian.dao.chat.entity;

import java.util.Date;

public class WechatMsg {
    private Long id;

    private Long msgId;

    private String toUserName;

    private String fromUserName;

    private String content;

    private String msgType;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public WechatMsg(Long id, Long msgId, String toUserName, String fromUserName, String content, String msgType, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.msgId = msgId;
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.content = content;
        this.msgType = msgType;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public WechatMsg() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName == null ? null : toUserName.trim();
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName == null ? null : fromUserName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
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