package com.example.tian.dao.chat;

import com.example.tian.dao.chat.entity.ChatOperationEntityLog;
import com.example.tian.dao.chat.entity.ChatOperationEntityLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatOperationEntityLogMapper {
    long countByExample(ChatOperationEntityLogExample example);

    int deleteByExample(ChatOperationEntityLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatOperationEntityLog record);

    int insertSelective(ChatOperationEntityLog record);

    List<ChatOperationEntityLog> selectByExample(ChatOperationEntityLogExample example);

    ChatOperationEntityLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatOperationEntityLog record, @Param("example") ChatOperationEntityLogExample example);

    int updateByExample(@Param("record") ChatOperationEntityLog record, @Param("example") ChatOperationEntityLogExample example);

    int updateByPrimaryKeySelective(ChatOperationEntityLog record);

    int updateByPrimaryKey(ChatOperationEntityLog record);
}