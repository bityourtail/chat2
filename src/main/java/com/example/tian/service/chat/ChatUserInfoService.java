package com.example.tian.service.chat;

import com.example.tian.common.enums.UserInfoStatusEnum;
import com.example.tian.dao.chat.ChatUserInfoDao;
import com.example.tian.dao.chat.entity.ChatUserInfo;
import com.example.tian.dto.wechatApi.WechatBasicMsgDto;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatUserInfoService {
    @Resource
    private ChatUserInfoDao chatUserInfoDao;

    //完善信息
    public List<WechatBasicMsgDto> completeMsg(String userId, int sex){
        if(chatUserInfoDao.isExist(userId)){
            throw new RuntimeException("该用户已存在");
        }

        List<WechatBasicMsgDto> result = new ArrayList<>();

        ChatUserInfo chatUserInfo = new ChatUserInfo();
        chatUserInfo.setUserId(userId);
        chatUserInfo.setSex(sex);
        chatUserInfo.setStatus(UserInfoStatusEnum.WAIT.getId());
        chatUserInfoDao.improveMsg(chatUserInfo);

        WechatBasicMsgDto msgDto = new WechatMsgDto();
        msgDto.setToUserName(userId);
        msgDto.setContent("信息完善成功");
        result.add(msgDto);

        return result;
    }
}
