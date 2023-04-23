package com.zz.dao.impl;

import com.zz.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * @author 朱喆
 * @version 1.0
 */
//<bean id="userDao" class="com.zz.dao.impl.UserDaoImpl"/>


//@Component("userDao")
@Repository("userDao")
@Scope("singleton")
@Lazy(value = true)
public class UserDaoImpl implements UserDao {

    //@Value("sn")
    private String name;

    //@Value("zz")
    @Value("${jdbc.Driver}")
    public void setName(String name){
        this.name=name;
    }



    public UserDaoImpl() {
        System.out.println("userDao创建");
    }

    @PostConstruct
    public void init(){
        System.out.println("userDao的初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("userDao销毁方法");
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
