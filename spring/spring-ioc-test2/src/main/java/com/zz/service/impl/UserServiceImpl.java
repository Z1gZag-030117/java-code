package com.zz.service.impl;

import com.zz.mapper.UserMapper;
import com.zz.dao.UserDao;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */

//@Component()
@Service("userService")
public class UserServiceImpl implements UserService {

//    @Autowired   //根据类型进行注入，如果同一个类有多个bean，尝试使用名字匹配，如果匹配不成功就报错
//    @Qualifier("userDao2")//根据名称注入相应的bean
//    @Resource(name = "userDao2") //不指定名称时，根据类型注入，指定名称就根据名称注入
//    private UserDao userDao;

//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    @Override
//    public void show() {
//        System.out.println(userDao);
//    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public void show(){
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}
