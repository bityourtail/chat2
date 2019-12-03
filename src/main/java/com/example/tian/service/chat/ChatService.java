package com.example.tian.service.chat;

import com.example.tian.common.enums.UserInfoStatusEnum;
import com.example.tian.dao.chat.ChatTalkMessageDao;
import com.example.tian.dao.chat.ChatUserInfoDao;
import com.example.tian.dao.chat.ChatUserPairDao;
import com.example.tian.dao.chat.entity.ChatTalkMessage;
import com.example.tian.dao.chat.entity.ChatUserInfo;
import com.example.tian.dto.wechatApi.WechatBasicMsgDto;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    @Resource
    private ChatUserInfoDao chatUserInfoDao;
    @Resource
    private ChatUserPairDao chatUserPairDao;
    @Resource
    private ChatTalkMessageDao chatTalkMessageDao;

    /*
    发起匹配
    userId  发起人id
    return  如果匹配成功，返回被匹配人id，
            如果没有匹配成功，返回非200
     */
    @Transactional
    public List<WechatBasicMsgDto> startChat(WechatMsgDto msgDto){
        List<WechatBasicMsgDto> result = new ArrayList<>();

        String userId = msgDto.getFromUserName();

        String oppositeSexId = getOppositeSexUserId(msgDto.getFromUserName());

        //如果没有合适的人，状态变为等待中
        if(StringUtils.isBlank(oppositeSexId)){
            updateUserStatus(userId,UserInfoStatusEnum.QUEUE.getId());
            result.add(setReplyContent(userId,"暂时没有合适的人，等待中..."));
        }else {
            //有的话，就拿出第一个，匹配成功;两个人状态变为聊天中
            updateUserStatus(userId,UserInfoStatusEnum.CHAT.getId());
            updateUserStatus(oppositeSexId,UserInfoStatusEnum.CHAT.getId());

            chatUserPairDao.addPair(userId,oppositeSexId);

            result.add(setReplyContent(userId,"匹配成功，可以开始聊天"));
            result.add(setReplyContent(oppositeSexId,"匹配成功，可以开始聊天"));
        }
        return result;
    }

    //更新用户状态
    private void updateUserStatus(String userId,int status){
        ChatUserInfo chatUserInfo = new ChatUserInfo();
        chatUserInfo.setStatus(status);
        chatUserInfo.setUserId(userId);
        chatUserInfoDao.updateMsg(chatUserInfo);
    }

    //设置回复内容
    private WechatBasicMsgDto setReplyContent(String userId,String content){
        WechatBasicMsgDto msgDto = new WechatBasicMsgDto();
        msgDto.setToUserName(userId);
        msgDto.setContent(content);
        return msgDto;
    }

    //选一个异性出来
    private String getOppositeSexUserId(String userId){
        /*
        获取性别
        选出最早的异性
         */

        ChatUserInfo userInfo = chatUserInfoDao.getUserInfoWithStatus(chatUserInfoDao.getUserInfo(userId).getSex()==0?1:0);
        if(userInfo ==null){
            return null;
        }

        return userInfo.getUserId();
    }

    //终止排队
    public List<WechatBasicMsgDto> giveupWait(WechatMsgDto msgDto){
        List<WechatBasicMsgDto> result = new ArrayList<>();

        String userId = msgDto.getFromUserName();

        updateUserStatus(userId,UserInfoStatusEnum.WAIT.getId());

        result.add(setReplyContent(userId,"终止排队"));

        return result;
    }


    /*
    断开匹配
    userId 断开人的id
    return 断开结果；1.没有可以断开的人，返回非200；2.断开成功，返回被断开人id
     */
    public List<WechatBasicMsgDto> closeChat(WechatMsgDto msgDto){

        List<WechatBasicMsgDto> result = new ArrayList<>();

        String userId = msgDto.getFromUserName();

        updateUserStatus(userId,UserInfoStatusEnum.WAIT.getId());

        //被匹配人的信息
        String pairedId = chatUserPairDao.getPair(userId);
        updateUserStatus(pairedId,UserInfoStatusEnum.WAIT.getId());

        result.add(setReplyContent(userId,"断开连接，可以发起新的匹配了"));
        result.add(setReplyContent(pairedId,"断开连接，可以发起新的匹配了"));

        return result;
    }

    /*
    开启免打扰
    return  不可重复开启免打扰
     */
    public List<WechatBasicMsgDto> startNotDisturb(WechatMsgDto msgDto){
        List<WechatBasicMsgDto> result = new ArrayList<>();

        updateUserStatus(msgDto.getFromUserName(),UserInfoStatusEnum.NOT_DISTURB.getId());

        result.add(setReplyContent(msgDto.getFromUserName(),"免打扰已开启"));

        return result;
    }

    /*
   关闭免打扰
    return  不可重复关闭免打扰
     */
    public List<WechatBasicMsgDto> endNotDisturb(WechatMsgDto msgDto){

        List<WechatBasicMsgDto> result = new ArrayList<>();

        updateUserStatus(msgDto.getFromUserName(),UserInfoStatusEnum.WAIT.getId());

        result.add(setReplyContent(msgDto.getFromUserName(),"免打扰已关闭"));

        return result;
    }

    /*
    发送消息
     */
    public List<WechatBasicMsgDto> chat(WechatMsgDto msgDto){
        if(StringUtils.isBlank(msgDto.getContent())){
            throw new RuntimeException("不可发送空消息");
        }
        List<WechatBasicMsgDto> result = new ArrayList<>();

        String receiverId = chatUserPairDao.getPair(msgDto.getFromUserName());

        addSendMsgLog(msgDto.getFromUserName(),receiverId,msgDto.getContent());

        result.add(setReplyContent(receiverId,msgDto.getContent()));

        return result;

    }

    //发送消息
    private void addSendMsgLog(String sendUserId,String receiveUserId,String content){
        ChatTalkMessage record = new ChatTalkMessage();
        record.setSenderUserId(sendUserId);
        record.setReceiverUserId(receiveUserId);
        record.setContent(content);
        chatTalkMessageDao.sendMsg(record);
    }

}
