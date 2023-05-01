package com.zz.factory;

import com.zz.dao.UserDao;
import com.zz.dao.impl.UserDaoImpl;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBeanFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
