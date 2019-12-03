package com.example.tian.common.utils;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HttpResponseUtils {


    //发送get，返回对象，如果为Null，表面请求失败
    //map为入参，没有就为null
    public static String getHttGETpResponse(String url, Map<String,String> map){
        if(map==null){
            return new RestTemplate().getForObject(url,String.class);
        }

        return new RestTemplate().getForObject(url,String.class,map);
    }
}
