package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatUserInfo;
import com.example.tian.dao.chat.entity.ChatUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatUserInfoMapper {
    long countByExample(ChatUserInfoExample example);

    int deleteByExample(ChatUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatUserInfo record);

    int insertSelective(ChatUserInfo record);

    List<ChatUserInfo> selectByExample(ChatUserInfoExample example);

    ChatUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatUserInfo record, @Param("example") ChatUserInfoExample example);

    int updateByExample(@Param("record") ChatUserInfo record, @Param("example") ChatUserInfoExample example);

    int updateByPrimaryKeySelective(ChatUserInfo record);

    int updateByPrimaryKey(ChatUserInfo record);
}