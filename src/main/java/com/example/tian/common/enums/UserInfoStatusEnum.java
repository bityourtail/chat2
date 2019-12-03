package com.example.tian.common.enums;

public enum UserInfoStatusEnum {
    WAIT(0,"等待中"),
    QUEUE(1,"队列中"),
    CHAT(2,"聊天中"),
    NOT_DISTURB(3,"免打扰")

    ;

    UserInfoStatusEnum(int id,String desc){
        this.id = id;
        this.desc = desc;
    }
    private int id;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
