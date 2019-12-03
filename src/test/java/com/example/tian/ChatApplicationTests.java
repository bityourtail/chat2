package com.example.tian;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

@SpringBootTest
class ChatApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.example.tian.dto.wechatApi.WechatMsgDto");
            Field[] fields = c.getDeclaredFields();

            for (Field field:fields){
                field.setAccessible(true);

                int i=4;
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
