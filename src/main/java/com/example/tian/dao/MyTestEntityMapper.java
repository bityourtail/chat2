package com.example.tian.dao;

import com.example.tian.dao.chat.MyTestEntity;
import com.example.tian.dao.chat.MyTestEntityExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MyTestEntityMapper {
    long countByExample(MyTestEntityExample example);

    int deleteByExample(MyTestEntityExample example);

    int insert(MyTestEntity record);

    int insertSelective(MyTestEntity record);

    List<MyTestEntity> selectByExample(MyTestEntityExample example);

    int updateByExampleSelective(@Param("record") MyTestEntity record, @Param("example") MyTestEntityExample example);

    int updateByExample(@Param("record") MyTestEntity record, @Param("example") MyTestEntityExample example);
}