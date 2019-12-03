package com.example.tian.dao;

import com.example.tian.dao.chat.MyTestEntity;
import com.example.tian.dao.chat.MyTestEntityExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestDao {

    @Resource
    private MyTestEntityMapper myTestMapper;

    public MyTestEntity getEntity(){
        return myTestMapper.selectByExample(new MyTestEntityExample()).get(0);
    }
}
