package com.example.tian.common.enums;

public enum  MsgReflectStatusEnum {
    FILL_MESSAGE("information",1,"完善信息"),
    START_CHAT("start",2,"开始聊天"),
    NOT_WAIT("notwait",3,"关闭排队"),
    CLOSE_CHAT("close",4,"结束聊天"),
    NOT_DISTURB("notdisturb",5,"开启免打扰"),
    DISTURB("disturb",6,"关闭免打扰"),
    CHAT("chat",7,"聊天"),

    ;

    MsgReflectStatusEnum(String msg,int status,String desc){
        this.msg = msg;
        this.status = status;
        this.desc = desc;
    }


    private String msg;
    private int status;
    private String desc;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static MsgReflectStatusEnum getMsgStatusEnum(String desc){
        MsgReflectStatusEnum[] enums = MsgReflectStatusEnum.values();
        for(int i=0;i<enums.length;i++){
            if(enums[i].getMsg().equals(desc)){
                return enums[i];
            }
        }
        return enums[0];
    }
}
