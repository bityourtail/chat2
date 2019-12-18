package com.example.tian.dao.msgstore;

import com.example.tian.dao.msgstore.entity.MsgStoreEntity;
import com.example.tian.dao.msgstore.entity.MsgStoreEntityExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MsgStoreEntityDao {
    @Resource
    private MsgStoreEntityMapper msgStoreEntityMapper;

    //存消息
    public void addMsg(MsgStoreEntity record){
        msgStoreEntityMapper.insertSelective(record);
    }

    //取消息
    public List<MsgStoreEntity> getMsg(String userId,String key){
        MsgStoreEntityExample example = new MsgStoreEntityExample();
        example.createCriteria().andUserIdEqualTo(userId).andKeyLike("%"+key+"%");
        return msgStoreEntityMapper.selectByExample(example);
    }
}
