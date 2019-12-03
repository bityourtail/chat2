package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatTalkMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatTalkMessageDao {
    @Resource
    private ChatTalkMessageMapper chatTalkMessageMapper;

    //发送消息
    public void sendMsg(ChatTalkMessage record){
        chatTalkMessageMapper.insertSelective(record);
    }
}
