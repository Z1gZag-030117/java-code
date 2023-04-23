package com.zz.dao.impl;

import com.zz.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author 朱喆
 * @version 1.0
 */
@Repository("userDao2")
public class UserDaoImpl2 implements UserDao {

    private String name;

    @Value("${jdbc.Driver}")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
