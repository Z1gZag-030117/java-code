package com.zz.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zz.pojo.User;
import com.zz.utiles.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
//@Controller
@RestController
public class UserController {

    @RequestMapping("/j1")
    //@ResponseBody
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        User user=new User("zz",20,"男");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/j2")
    //@ResponseBody
    public String json2(){
        Date date = new Date();
        return JsonUtil.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    //fastjson使用
    @RequestMapping("/j3")
    public String json3(){
        List<User> userList=new ArrayList<>();
        User user1 = new User("zz1", 1, "男");
        User user2 = new User("zz2", 2, "男");
        User user3 = new User("zz3", 3, "男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String s = JSON.toJSONString(userList);
        return s;
    }


}
