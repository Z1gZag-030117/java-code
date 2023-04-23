package com.zz.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //2.设置当前访问的请求路径
    @RequestMapping("/show")
    //3.设置当前操作的返回值类型
    @ResponseBody
    public String show() {
        System.out.println("user show running...");
        return "{'module':'springmvc'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        System.out.println("delete running...");
        return "{'module':'springmvc'}";
    }

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age) {
        System.out.println("普通参数传递：" + name + age);
        return "{'module':'common param'}";
    }

    @PostMapping("/listParamForJson")
    public String listParamForJson(@RequestBody String body) throws IOException {
        //使用jackson进行转换，将json格式的字符串转换成user对象
        ObjectMapper objectMapper=new ObjectMapper();
        User user = objectMapper.readValue(body, User.class);
        System.out.println(user);
        return "/index.jsp";
    }


    @PostMapping(value = "/pojoParamForJson")
    public String pojoParamForJson(User user){
        System.out.println("pojo common(json)参数传递 user ="+user);
        return "{'module':'pojo common for json param'}";
    }
}
