package com.example.tian.dao.msgstore.entity;

import java.util.Date;

public class MsgStoreEntity {
    private Long id;

    private String userId;

    private String vKey;

    private String vValue;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public MsgStoreEntity(Long id, String userId, String vKey, String vValue, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.userId = userId;
        this.vKey = vKey;
        this.vValue = vValue;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public MsgStoreEntity() {
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

    public String getvKey() {
        return vKey;
    }

    public void setvKey(String vKey) {
        this.vKey = vKey == null ? null : vKey.trim();
    }

    public String getvValue() {
        return vValue;
    }

    public void setvValue(String vValue) {
        this.vValue = vValue == null ? null : vValue.trim();
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