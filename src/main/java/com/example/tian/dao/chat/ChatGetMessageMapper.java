package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatGetMessage;
import com.example.tian.dao.chat.entity.ChatGetMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatGetMessageMapper {
    long countByExample(ChatGetMessageExample example);

    int deleteByExample(ChatGetMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatGetMessage record);

    int insertSelective(ChatGetMessage record);

    List<ChatGetMessage> selectByExample(ChatGetMessageExample example);

    ChatGetMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatGetMessage record, @Param("example") ChatGetMessageExample example);

    int updateByExample(@Param("record") ChatGetMessage record, @Param("example") ChatGetMessageExample example);

    int updateByPrimaryKeySelective(ChatGetMessage record);

    int updateByPrimaryKey(ChatGetMessage record);
}