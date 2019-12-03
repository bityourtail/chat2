package com.example.tian.controller.wechat;

import com.example.tian.dao.chat.WechatMsgDao;
import com.example.tian.dto.wechatApi.WechatBasicMsgDto;
import com.example.tian.dto.wechatApi.WechatMsgDto;
import com.example.tian.service.chat.WechatReflectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@RestController
@Slf4j
public class WechatController {
    @Resource
    private WechatReflectService wechatReflectService;

    @Resource
    private WechatMsgDao wechatMsgDao;

    @RequestMapping(value = "/wx", method = {RequestMethod.GET, RequestMethod.POST})
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //如果为get请求，则为开发者模式验证
        if ("get".equals(request.getMethod().toLowerCase())) {
            out.print(request.getParameter("echostr"));
        } else {
            WechatMsgDto msgDto = WechatMsgDto.newDeclareDto(request);

            if(msgDto==null){
                log.error("解析微信消息有误");
                out.print("");
                return;
            }

            //记录微信消息到日志
            wechatMsgDao.addMsg(msgDto);

            try {
                List<WechatBasicMsgDto> msgDtoList =  wechatReflectService.reflectStatus(msgDto);
                //发送消息sss
                for(WechatBasicMsgDto msg:msgDtoList){
                    //原来【接收消息用户】变为回复时【发送消息用户】
                    String result = WechatBasicMsgDto.initText(msg, msgDto.getToUserName());
                    System.out.println(result);
                    out.print(result);
                }
            }catch (RuntimeException e){
                WechatBasicMsgDto msg = new WechatBasicMsgDto();
                msg.setFromUserName(msgDto.getToUserName());
                msg.setToUserName(msgDto.getFromUserName());
                msg.setContent(e.getMessage());

                String result = WechatBasicMsgDto.initText(msg, msgDto.getToUserName());
                System.out.println(result);
                out.print(result);
            }
        }
    }
}
