package com.example.tian.dto.wechatApi;

import lombok.Data;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class WechatMsgDto extends WechatBasicMsgDto{

    private String msgId;

    //将xmlString转化为object
    public static WechatMsgDto newDeclareDto(HttpServletRequest request) {
        Map<String, String> msg = xmlToMap(request);
        if(msg==null){
            return null;
        }
        WechatMsgDto result = new WechatMsgDto();
        result.setMsgId(msg.get("MsgId"));
        result.setContent(msg.get("Content"));
        result.setToUserName(msg.get("ToUserName"));
        result.setFromUserName(msg.get("FromUserName"));
        result.setCreateTime(Long.parseLong(msg.get("CreateTime")));
        result.setMsgType(msg.get("MsgType"));


//        Class<WechatMsgDto> c = WechatMsgDto.class;
//        WechatMsgDto result = new WechatMsgDto();
//        Field[] fields = c.getDeclaredFields();
//        try {
//            for (Field field : fields) {
//                field.setAccessible(true);
//                if (msg.containsKey(field.getName())) {
//                    field.set(result, msg.get(field.getName()));
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        return result;
    }


    /**
     * 新建方法，将接收到的XML格式，转化为Map对象
     *
     * @param request 将request对象，通过参数传入
     * @return 返回转换后的Map对象
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) {
        try {
            Map<String, String> map = new HashMap<>();
            //从dom4j的jar包中，拿到SAXReader对象。
            SAXReader reader = new SAXReader();
            InputStream is = request.getInputStream();//从request中，获取输入流
            Document doc = reader.read(is);//从reader对象中,读取输入流
            Element root = doc.getRootElement();//获取XML文档的根元素
            List<Element> list = root.elements();//获得根元素下的所有子节点
            for (Element e : list) {
                map.put(e.getName(), e.getText());//遍历list对象，并将结果保存到集合中
            }
            is.close();
            return map;
        } catch (Exception e) {
            return null;
        }
    }
}
