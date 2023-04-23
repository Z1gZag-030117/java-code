package com.zz;

import com.zz.Interface.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/**
 * @author 朱喆
 * @version 1.0
 */
public class notCustomized {

    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1");
        Statement statement = connection.createStatement();

    }

    @Test
    public void testDate() throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date parse = simpleDateFormat.parse("2023-3-6 12:00:00");
//        System.out.println(parse);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("notCustomized.xml");
        Object date = applicationContext.getBean("date");
        System.out.println(date);
    }

    @Test
    public void testBeanFactoryPostProcessor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("post.xml");
        PersonDao bean = context.getBean(PersonDao.class);
        System.out.println(bean);     //   com.zz.UserDao@4bb4de6a
    }

    @Test
    public void testBeanPostProcessor(){

//        userDao被创立
//        userDao : postProcessBeforeInitialization
//        属性设置之后执行
//        init
//        userDao : postProcessAfterInitialization


        ApplicationContext context= new ClassPathXmlApplicationContext("post.xml");
        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("userDao");
        //System.out.println(userDaoImpl.getUsername());
    }
    @Test
    public void testTimeLogBeanPostProcessor(){

        ApplicationContext context= new ClassPathXmlApplicationContext("post.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.hello();
    }

    @Test
    public void testMyComponent(){
        ApplicationContext context = new ClassPathXmlApplicationContext("post.xml");
        Pet bean = context.getBean(Pet.class);
        System.out.println(bean);
    }







}
