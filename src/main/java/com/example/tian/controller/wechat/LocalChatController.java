package com.example.tian.controller.wechat;

import com.example.tian.dto.wechatApi.WechatBasicMsgDto;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import com.example.tian.service.chat.WechatReflectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LocalChatController {
    @Resource
    private WechatReflectService wechatReflectService;

    @GetMapping("/wechat")
    public List<WechatBasicMsgDto> wechat(String uId, String content){
        WechatMsgDto msgDto = new WechatMsgDto();
        msgDto.setFromUserName(uId);
        msgDto.setContent(content);
        return wechatReflectService.reflectStatus(msgDto);
    }
}
