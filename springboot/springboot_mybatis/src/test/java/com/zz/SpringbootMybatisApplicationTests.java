package com.zz;

import com.zz.dao.UserDao;
import com.zz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User byId = userDao.getById(1);
        System.out.println(byId);
    }

}
