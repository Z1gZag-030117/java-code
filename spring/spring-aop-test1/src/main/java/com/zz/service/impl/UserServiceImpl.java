package com.zz.service.impl;

import com.zz.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    public void show1() {
        System.out.println("show1");
    }

    public void show2() {
        System.out.println("show2");
    }
}
