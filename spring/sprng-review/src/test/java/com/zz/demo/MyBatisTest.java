package com.zz.demo;

import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBatisTest {

    private ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Test
    public void test1() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        UserService userService = application.getBean(UserService.class);
        userService.show();
    }

}
