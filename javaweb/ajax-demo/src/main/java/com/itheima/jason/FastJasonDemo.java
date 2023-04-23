package com.itheima.jason;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.User;

/**
 * @author 朱喆
 * @version 1.0
 */
public class FastJasonDemo {

    public static void main(String[] args) {

        User user=new User();
        user.setUsername("zz");
        user.setPassword("123");
        user.setId(1);

        String s = JSON.toJSONString(user);
        System.out.println(s);


        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zz\"}", User.class);
        System.out.println(user1);


    }
}
