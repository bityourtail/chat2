package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.WechatMsg;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WechatMsgDao {
    @Resource
    private WechatMsgMapper wechatMsgMapper;

    //添加一条消息
    public void addMsg(WechatMsgDto msgDto){
        WechatMsg record = new WechatMsg();
        BeanUtils.copyProperties(msgDto,record);

        wechatMsgMapper.insertSelective(record);
    }
}
