package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatTalkMessage;
import com.example.tian.dao.chat.entity.ChatTalkMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatTalkMessageMapper {
    long countByExample(ChatTalkMessageExample example);

    int deleteByExample(ChatTalkMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatTalkMessage record);

    int insertSelective(ChatTalkMessage record);

    List<ChatTalkMessage> selectByExample(ChatTalkMessageExample example);

    ChatTalkMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatTalkMessage record, @Param("example") ChatTalkMessageExample example);

    int updateByExample(@Param("record") ChatTalkMessage record, @Param("example") ChatTalkMessageExample example);

    int updateByPrimaryKeySelective(ChatTalkMessage record);

    int updateByPrimaryKey(ChatTalkMessage record);
}