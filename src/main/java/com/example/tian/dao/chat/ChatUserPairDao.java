package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatUserPair;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChatUserPairDao {
    @Resource
    private ChatUserPairMapper chatUserPairMapper;
    @Resource
    private ChatUserPairMapper2 chatUserPairMapper2;

    //新增匹配关系
    public void addPair(String pairId,String pairedId){
        ChatUserPair record = new ChatUserPair();
        record.setPairUserId(pairId);
        record.setPairedUserId(pairedId);
        record.setStatus(0);
        chatUserPairMapper.insertSelective(record);
    }

    //查找匹配关系
    public String getPair(String pairId){
        return chatUserPairMapper2.getPairId(pairId);
    }
}
