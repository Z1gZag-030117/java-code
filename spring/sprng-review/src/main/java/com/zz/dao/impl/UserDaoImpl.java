package com.zz.dao.impl;

import com.zz.dao.UserDao;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void show() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("show...");
    }
}
