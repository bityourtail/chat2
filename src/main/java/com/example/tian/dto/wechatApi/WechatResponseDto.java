package com.example.tian.dto.wechatApi;

import lombok.Data;

@Data
public class WechatResponseDto {

    private String ToUserName;

    private String FromUserName;

    private Long CreateTime;

    private String MsgType;

    private String Content;
}
