package com.example.tian.dto.wechatApi;

import com.thoughtworks.xstream.XStream;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
//微信回复消息对象
public class WechatBasicMsgDto {

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private String msgType;

    private String content;

    /**
     * 初始化回复消息
     */
    public static String initText(WechatBasicMsgDto msg,String fromUserName) {
        WechatResponseDto text = new WechatResponseDto();
        text.setFromUserName(fromUserName);
        text.setToUserName(msg.getToUserName());
        text.setMsgType("text");
        text.setCreateTime(new Date().getTime());//创建当前时间为消息时间
        text.setContent(msg.getContent());
        return TextMessageToXml(text);
    }

    /**
     * 将文本消息对象转化成XML格式
     *
     * @param message 文本消息对象
     * @return 返回转换后的XML格式
     */
    public static String TextMessageToXml(WechatResponseDto message) {
        XStream xs = new XStream();
        //由于转换后xml根节点默认为class类，需转化为<xml>
        xs.alias("xml", message.getClass());
        return xs.toXML(message);
    }
}
