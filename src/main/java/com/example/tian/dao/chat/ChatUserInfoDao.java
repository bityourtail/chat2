package com.example.tian.dao.chat;

import com.alibaba.fastjson.JSON;
import com.example.tian.common.enums.UserInfoStatusEnum;
import com.example.tian.dao.chat.entity.ChatUserInfo;
import com.example.tian.dao.chat.entity.ChatUserInfoExample;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChatUserInfoDao {
    @Resource
    private ChatUserInfoMapper chatUserInfoMapper;
    @Resource
    private ChatUserInfoMapper2 chatUserInfoMapper2;

    //完善用户信息
    public void improveMsg(ChatUserInfo chatUserInfo){
        System.out.println("插入数据" + JSON.toJSONString(chatUserInfo));
        chatUserInfoMapper.insertSelective(chatUserInfo);
    }

    //查询用户是否存在
    public boolean isExist(String userId){
        ChatUserInfoExample example = new ChatUserInfoExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return !CollectionUtils.isEmpty(chatUserInfoMapper.selectByExample(example));
    }

    //查询用户信息
    public ChatUserInfo getUserInfo(String userId){
        ChatUserInfoExample example = new ChatUserInfoExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<ChatUserInfo> infos = chatUserInfoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(infos)){
            throw new RuntimeException("用户id有误");
        }
        return infos.get(0);
    }

    //查询某个状态下的用户
    public ChatUserInfo getUserInfoWithStatus(int sex){
        ChatUserInfoExample example = new ChatUserInfoExample();
        example.setOrderByClause("db_update_time");
        example.createCriteria().andStatusEqualTo(UserInfoStatusEnum.QUEUE.getId()).andSexEqualTo(sex);

        List<ChatUserInfo> users = chatUserInfoMapper.selectByExample(example);

        if(CollectionUtils.isEmpty(users)){
            return null;
        }
        return users.get(0);
    }

    //更新用户状态
    public void updateMsg(ChatUserInfo chatUserInfo){
        ChatUserInfoExample example = new ChatUserInfoExample();
        example.createCriteria().andUserIdEqualTo(chatUserInfo.getUserId());
        chatUserInfoMapper.updateByExampleSelective(chatUserInfo,example);
    }

    //检查出长时间未匹配到的用户
    public List<String> checkLongTimeUser(){
        return chatUserInfoMapper2.checkLongTimeUser();
    }

}
