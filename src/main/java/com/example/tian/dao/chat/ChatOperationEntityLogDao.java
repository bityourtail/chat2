package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatOperationEntityLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatOperationEntityLogDao {
    @Resource
    private ChatOperationEntityLogMapper chatOperationEntityLogMapper;

    //添加一条日志信息
    public void addLog(String userId,int type){
        ChatOperationEntityLog log = new ChatOperationEntityLog();
        log.setUserId(userId);
        log.setType(type);
        chatOperationEntityLogMapper.insertSelective(log);
    }
}
