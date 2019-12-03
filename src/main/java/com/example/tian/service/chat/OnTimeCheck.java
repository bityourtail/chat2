package com.example.tian.service.chat;

import com.example.tian.common.enums.UserInfoStatusEnum;
import com.example.tian.dao.chat.ChatUserInfoDao;
import com.example.tian.dao.chat.entity.ChatUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

//定时任务类
@Slf4j
public class OnTimeCheck {
    @Resource
    private ChatUserInfoDao chatUserInfoDao;

    //定时检查长时间在队列中的用户，状态变为“等待中”
    @Scheduled(fixedDelay = 3600*1000)
    @Transactional
    public void checkStatus(){
        List<String> userIds = chatUserInfoDao.checkLongTimeUser();

        if(CollectionUtils.isEmpty(userIds)){
            return;
        }

        log.info("本次自动断开连接人数：{}人",userIds.size());

        for (String userId:userIds){
            ChatUserInfo chatUserInfo = new ChatUserInfo();
            chatUserInfo.setUserId(userId);
            chatUserInfo.setStatus(UserInfoStatusEnum.WAIT.getId());

            chatUserInfoDao.updateMsg(chatUserInfo);
        }
    }
}
