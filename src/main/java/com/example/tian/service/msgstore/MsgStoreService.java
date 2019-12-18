package com.example.tian.service.msgstore;

import com.example.tian.dao.msgstore.MsgStoreEntityDao;
import com.example.tian.dao.msgstore.entity.MsgStoreEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MsgStoreService {
    @Resource
    private MsgStoreEntityDao msgStoreEntityDao;

    //放消息
    public String addMsg(String userId,String content){

        MsgStoreEntity record = new MsgStoreEntity();
        record.setUserId(userId);
        setContent(content,record);
        msgStoreEntityDao.addMsg(record);

        return "添加ok";
    }

    //拆分消息
    private void setContent(String content,MsgStoreEntity record){
        if(StringUtils.isBlank(content)){
            throw new RuntimeException("不可保存空消息");
        }
        if(!content.contains(" ")){
            throw new RuntimeException("请以键值对方式输入");
        }
        String key="",value="";
        for(int i=0;i<content.length();i++){
            if(content.charAt(i)==' '){
                key = content.substring(0,i);
                value = content.substring(i);
            }
        }
        record.setKey(key.trim());
        record.setValue(value.trim());
    }

    //取消息
    public String getMsg(String userId,String key){
        String result = "";
        List<MsgStoreEntity> list =  msgStoreEntityDao.getMsg(userId,key);
        if(CollectionUtils.isEmpty(list)){
            return result;
        }

        if(list.size()>10){
            result+="该关键词有多个相近的答案，尝试更精确试试";
        }
        for(int i=0;i<list.size();i++){
            result+="\r\n key: "+list.get(i).getKey()+"  value: "+list.get(i).getValue();
        }
        return result;
    }
}
