package com.example.tian.dao.chat;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ChatUserPairMapper2 {

    @Select("select paired_user_id from chat_user_pair where pair_user_id = #{pairId} order by db_update_time desc limit 1")
    String getPairId(@Param("pairId") String pairId);
}
