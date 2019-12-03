package com.example.tian.service.chat;

import com.alibaba.fastjson.JSON;
import com.example.tian.common.enums.MsgReflectStatusEnum;
import com.example.tian.common.enums.UserInfoStatusEnum;
import com.example.tian.dao.chat.ChatOperationEntityLogDao;
import com.example.tian.dao.chat.ChatUserInfoDao;
import com.example.tian.dao.chat.entity.ChatUserInfo;
import com.example.tian.dto.wechatApi.WechatBasicMsgDto;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WechatReflectService {

    @Resource
    private ChatUserInfoDao chatUserInfoDao;
    @Resource
    private ChatService chatService;
    @Resource
    private ChatUserInfoService chatUserInfoService;
    @Resource
    private ChatOperationEntityLogDao chatOperationEntityLogDao;

    //根据输入，调用相应的方法,并返回需要发送的消息
    /*
    包含如下几步：
    1.匹配输入
    2.校验该输入的状态是否合法，不合法就抛出异常，合法则返回需要发送的消息
     */
    public List<WechatBasicMsgDto> reflectStatus(WechatMsgDto msgDto) {
        String userId = msgDto.getFromUserName();

        System.out.println("debug: " + JSON.toJSONString(msgDto));
        if(msgDto.getContent().equals("information男")){
            judgeCanFillInformation(userId);
            chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.FILL_MESSAGE.getStatus());
            return chatUserInfoService.completeMsg(userId,0);
        }else if(msgDto.getContent().equals("information女")){
            judgeCanFillInformation(userId);
            chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.FILL_MESSAGE.getStatus());
            return chatUserInfoService.completeMsg(userId,1);
        }

        switch (MsgReflectStatusEnum.getMsgStatusEnum(msgDto.getContent())) {
            case START_CHAT: {
                judgeCanStartChat(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.START_CHAT.getStatus());
                return chatService.startChat(msgDto);
            }
            case NOT_WAIT: {
                judgeCanGiveUpWait(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.NOT_WAIT.getStatus());
                return chatService.giveupWait(msgDto);
            }
            case CLOSE_CHAT: {
                judgeCanCloseChat(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.CLOSE_CHAT.getStatus());
                return chatService.closeChat(msgDto);
            }
            case NOT_DISTURB: {
                judgeCanStartNoDisturb(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.NOT_DISTURB.getStatus());
                return chatService.startNotDisturb(msgDto);
            }
            case DISTURB: {
                judgeCanCloseNoDisturb(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.DISTURB.getStatus());
                return chatService.endNotDisturb(msgDto);
            }
            default: {
                judgeCanChat(userId);
                chatOperationEntityLogDao.addLog(msgDto.getFromUserName(), MsgReflectStatusEnum.CHAT.getStatus());
                return chatService.chat(msgDto);
            }
        }
    }

    //判断是否能完善信息
    private void judgeCanFillInformation(String userId) {

        ChatUserInfo userInfo = null;
        try {
            userInfo = chatUserInfoDao.getUserInfo(userId);

        }catch (Exception e){
        }
        if(userInfo!=null){
            throw new RuntimeException("用户已填写信息，不能重复填写！");
        }


    }

    //判断是否能开始聊天
    private void judgeCanStartChat(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.WAIT.getId()) {
            throw new RuntimeException("用户状态不在等待中！");
        }
    }

    //判断是否能放弃等待
    private void judgeCanGiveUpWait(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.QUEUE.getId()) {
            throw new RuntimeException("用户状态不在聊天中！");
        }
    }

    //判断是否能关闭聊天
    private void judgeCanCloseChat(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.CHAT.getId()) {
            throw new RuntimeException("用户状态不在聊天中！");
        }
    }

    //判断是否能开启免打扰
    private void judgeCanStartNoDisturb(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.WAIT.getId()) {
            throw new RuntimeException("用户状态不在等待中！");
        }
    }

    //判断是否能关闭免打扰
    private void judgeCanCloseNoDisturb(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.NOT_DISTURB.getId()) {
            throw new RuntimeException("用户状态不在等待中！");
        }
    }

    //判断是否能聊天
    private void judgeCanChat(String userId) {
        ChatUserInfo userInfo = chatUserInfoDao.getUserInfo(userId);
        if (userInfo.getStatus() != UserInfoStatusEnum.CHAT.getId()) {
            throw new RuntimeException("用户状态不在等待中！");
        }
    }
}
