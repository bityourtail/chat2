package com.example.tian.chat;

import com.example.tian.BaseTest;
import com.example.tian.service.chat.ChatUserInfoService;
import org.junit.Test;

import javax.annotation.Resource;

public class ChatUserInfoServiceTest extends BaseTest {
    @Resource
    private ChatUserInfoService chatUserInfoService;

    @Test
    public void test(){
        chatUserInfoService.completeMsg("zf",1);
    }
}
