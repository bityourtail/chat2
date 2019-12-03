package com.example.tian.service.wechatApi;

import com.alibaba.fastjson.JSON;
import com.example.tian.common.utils.HttpResponseUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WechatService {

    //token值
    private String token;
    //token更改时间
    private Long tokenFixTime;
    //过期时间
    private int expiresIn;
    //微信信息，重要
    private String grant_type = "client_credential";
    private String appid = "wx2e47edf16924f107";
    private String secret = "6b42ea6771ece5d05ff1d4c86992cc11";
    private String token_url = "https://api.weixin.qq.com/cgi-bin/token";

    //获取token
    public String getToken(){
        if(StringUtils.isNotBlank(token)&&!isExpire()){
            return token;
        }
        Map<String,String> map = new HashMap<>();
        map.put("grant_type",grant_type);
        map.put("appid",appid);
        map.put("secret",secret);
        String tokenResponse = HttpResponseUtils.getHttGETpResponse(token_url,map);
        token = JSON.parseObject(tokenResponse,WechaResponseDto.class).getAccess_token();
        expiresIn = JSON.parseObject(tokenResponse,WechaResponseDto.class).getExpires_in();
        tokenFixTime = System.currentTimeMillis();
        return token;
    }

    @Data
    class WechaResponseDto{
        private String access_token;
        private int expires_in;
    }

    //判断token是否过期
    private boolean isExpire(){
        if(System.currentTimeMillis()-tokenFixTime<expiresIn){
            return false;
        }
        return true;
    }

}
