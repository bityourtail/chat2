package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatUserPair;
import com.example.tian.dao.chat.entity.ChatUserPairExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatUserPairMapper {
    long countByExample(ChatUserPairExample example);

    int deleteByExample(ChatUserPairExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatUserPair record);

    int insertSelective(ChatUserPair record);

    List<ChatUserPair> selectByExample(ChatUserPairExample example);

    ChatUserPair selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatUserPair record, @Param("example") ChatUserPairExample example);

    int updateByExample(@Param("record") ChatUserPair record, @Param("example") ChatUserPairExample example);

    int updateByPrimaryKeySelective(ChatUserPair record);

    int updateByPrimaryKey(ChatUserPair record);
}