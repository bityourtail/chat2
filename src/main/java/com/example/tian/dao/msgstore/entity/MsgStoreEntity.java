package com.example.tian.dao.msgstore.entity;

import java.util.Date;

public class MsgStoreEntity {
    private Long id;

    private String userId;

    private String key;

    private String value;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public MsgStoreEntity(Long id, String userId, String key, String value, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.userId = userId;
        this.key = key;
        this.value = value;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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