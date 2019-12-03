package com.example.tian.controller;

import com.example.tian.dao.chat.MyTestEntity;
import com.example.tian.service.TestSevice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestSevice testSevice;
    @RequestMapping("/abc")
    public MyTestEntity get(){
        return testSevice.get();
    }
}
