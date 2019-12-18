package com.example.tian.service.chat;

import com.example.tian.dto.wechatApi.WechatMsgDto;
import com.example.tian.service.msgstore.MsgStoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WechatReflectService {

    @Resource
    private MsgStoreService msgStoreService;

    //根据输入，调用相应的方法,并返回需要发送的消息
    /*
    包含如下几步：
    1.匹配输入
    2.校验该输入的状态是否合法，不合法就抛出异常，合法则返回需要发送的消息
     */
    public String reflectStatus(WechatMsgDto msgDto) {
        String content = msgDto.getContent().trim();
        if(content.contains(" ")){
            return msgStoreService.addMsg(msgDto.getFromUserName(),msgDto.getContent());
        }else {
            return msgStoreService.getMsg(msgDto.getFromUserName(),msgDto.getContent());
        }
    }

}
