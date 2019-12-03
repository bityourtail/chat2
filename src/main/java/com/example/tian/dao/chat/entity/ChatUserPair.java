package com.example.tian.dao.chat.entity;

import java.util.Date;

public class ChatUserPair {
    private Long id;

    private String pairUserId;

    private String pairedUserId;

    private Integer status;

    private Date dbCreateTime;

    private Date dbUpdateTime;

    public ChatUserPair(Long id, String pairUserId, String pairedUserId, Integer status, Date dbCreateTime, Date dbUpdateTime) {
        this.id = id;
        this.pairUserId = pairUserId;
        this.pairedUserId = pairedUserId;
        this.status = status;
        this.dbCreateTime = dbCreateTime;
        this.dbUpdateTime = dbUpdateTime;
    }

    public ChatUserPair() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPairUserId() {
        return pairUserId;
    }

    public void setPairUserId(String pairUserId) {
        this.pairUserId = pairUserId == null ? null : pairUserId.trim();
    }

    public String getPairedUserId() {
        return pairedUserId;
    }

    public void setPairedUserId(String pairedUserId) {
        this.pairedUserId = pairedUserId == null ? null : pairedUserId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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