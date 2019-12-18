package com.example.tian.msgstore;

import com.example.tian.BaseTest;
import com.example.tian.service.msgstore.MsgStoreService;
import org.junit.Test;

import javax.annotation.Resource;

public class MsgStoreServiceTestt extends BaseTest {

    @Resource
    private MsgStoreService msgStoreService;

    @Test
    public void test(){
        msgStoreService.addMsg("abc","dce sdf");
    }
}
