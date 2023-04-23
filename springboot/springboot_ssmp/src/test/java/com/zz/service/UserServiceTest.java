package com.zz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 朱喆
 * @version 1.0
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("zz");
        user.setPassword("20030117");
        user.setGender("man");
        user.setAddr("guali");
        System.out.println("userService.save(user) = " + userService.save(user));
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(2);
        user.setUsername("朱喆");
        user.setPassword("030117");
        user.setGender("男");
        user.setAddr("瓜沥");
        userService.update(user);
    }


    @Test
    void testGetById() {
        System.out.println(userService.getById(2));
    }

    @Test
    void testGetAll() {
        System.out.println(userService.getAll());
    }

    @Test
    void testGetByPage() {
        IPage<User> page = userService.getPage(1, 3);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getRecords() = " + page.getRecords());
    }

}
