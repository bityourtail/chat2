package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatMessage;
import com.example.tian.dao.chat.entity.ChatMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMessageMapper {
    long countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExample(ChatMessageExample example);

    ChatMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}