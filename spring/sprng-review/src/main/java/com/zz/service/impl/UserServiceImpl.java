package com.zz.service.impl;

import com.zz.dao.UserDao;
import com.zz.dao.impl.UserDaoImpl;
import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.service.UserService;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void show(){
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Override
    public void save() {
        System.out.println("save ...");
    }

    public void setUserDao(UserDao userDao){
        System.out.println(userDao);
    }


}
