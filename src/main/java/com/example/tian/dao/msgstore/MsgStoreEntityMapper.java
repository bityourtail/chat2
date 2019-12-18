package com.example.tian.dao.msgstore;

import com.example.tian.dao.msgstore.entity.MsgStoreEntity;
import com.example.tian.dao.msgstore.entity.MsgStoreEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgStoreEntityMapper {
    long countByExample(MsgStoreEntityExample example);

    int deleteByExample(MsgStoreEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgStoreEntity record);

    int insertSelective(MsgStoreEntity record);

    List<MsgStoreEntity> selectByExample(MsgStoreEntityExample example);

    MsgStoreEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgStoreEntity record, @Param("example") MsgStoreEntityExample example);

    int updateByExample(@Param("record") MsgStoreEntity record, @Param("example") MsgStoreEntityExample example);

    int updateByPrimaryKeySelective(MsgStoreEntity record);

    int updateByPrimaryKey(MsgStoreEntity record);
}