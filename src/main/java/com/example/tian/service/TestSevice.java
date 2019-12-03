package com.example.tian.service;

import com.example.tian.dao.TestDao;
import com.example.tian.dao.chat.MyTestEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestSevice {
    @Resource
    private TestDao testDao;

    public MyTestEntity get(){
        return testDao.getEntity();
    }
}
