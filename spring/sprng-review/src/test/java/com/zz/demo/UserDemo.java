package com.zz.demo;

import com.zz.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserDemo {

    public static void main(String[] args) {

        ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) application.getBean("userService");
        userService.save();

    }

}
