package com.example.tian.dto;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private int code;
    private String msg;
    private T result;

    public CommonResponse(int code,String msg,T result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static CommonResponse CreateSuccessResponse(){
        return new CommonResponse(200,"ok",null);
    }

    public static <T> CommonResponse CreateSuccessResponse(T result){
        return new CommonResponse(200,"ok",result);
    }

    public static CommonResponse CreateErrorResponse(){
        return new CommonResponse(400,"error",null);
    }
}
