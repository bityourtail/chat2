package com.example.tian.service.chat;

import org.springframework.stereotype.Service;

/**
 * 帮助功能
 */
@Service
public class HelpService {

    public String getHelp(){
        return "无法识别，请输入合法的信息";
    }
}
