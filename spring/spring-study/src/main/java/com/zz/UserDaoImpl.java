package com.zz;

import com.zz.Interface.UserDao;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserDaoImpl implements UserDao ,InitializingBean{

    @Override
    public void hello() {
        System.out.println("hello");
    }


    private String username;

    public UserDaoImpl() {
        System.out.println("userDao被创立");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void init(){
        System.out.println("init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("属性设置之后执行");
    }


}
