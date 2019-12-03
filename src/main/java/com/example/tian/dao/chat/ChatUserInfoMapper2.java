package com.example.tian.dao.chat;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChatUserInfoMapper2 {

    @Select("select user_id from chat_user_info where status = 1 and db_update_time>NOW()-INTERVAL 15 HOUR")
    List<String> checkLongTimeUser();
}
