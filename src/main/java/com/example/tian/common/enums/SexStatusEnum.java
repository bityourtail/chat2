package com.example.tian.common.enums;

public enum SexStatusEnum {
    BOY(0,"男"),
    GIRL(1,"女")

    ;

    SexStatusEnum(int id,String desc){
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

    public static int getOppositeSex(int id){
        if(id==SexStatusEnum.BOY.getId()){
            return SexStatusEnum.GIRL.getId();
        }else {
            return SexStatusEnum.BOY.getId();
        }
    }
}
