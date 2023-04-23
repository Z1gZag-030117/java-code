package com.zz.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zz.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 朱喆
 * @version 1.0
 */
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetById() {
        System.out.println(userDao.selectById(2));
    }

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("gly");
        user.setPassword("00000");
        user.setGender("女");
        user.setAddr("萧山");
        userDao.insert(user);
    }

    @Test
    void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("99990");
        user.setGender("女");
        user.setAddr("萧山");
        userDao.updateById(user);
    }

    @Test
    void testDelete() {
        userDao.deleteById(3);
    }

    @Test
    void testGetAll() {
        System.out.println(userDao.selectList(null));
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 3);
        userDao.selectPage(page, null);
        System.out.println("page.getCurrent() = " + page.getCurrent());
        System.out.println("page.getSize() = " + page.getSize());
        System.out.println("page.getTotal() = " + page.getTotal());
        System.out.println("page.getPages() = " + page.getPages());
        System.out.println("page.getRecords() = " + page.getRecords());
        /*
        page.getCurrent() = 1
        page.getSize() = 3
        page.getTotal() = 4
        page.getPages() = 2
        page.getRecords() = [User(id=1, username=张三, password=99990, gender=女, addr=萧山), User(id=2, username=李四, password=234, gender=女, addr=天津), User(id=4, username=sn, password=0000, gender=女, addr=杭州)]
         */
    }

    @Test
    void testGetBy() {
        String name = "sn";
//        QueryWrapper<User> queryWrapper=new QueryWrapper();
//        queryWrapper.like("username","n");
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(name != null, User::getUsername, name);
        System.out.println(userDao.selectList(lambdaQueryWrapper));
    }


}
