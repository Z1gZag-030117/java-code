package com.zz.demo;

import com.zz.dao.PersonDao;
import com.zz.dao.UserDao;
import com.zz.dao.impl.UserDaoImpl;
import com.zz.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 朱喆
 * @version 1.0
 */
public class UserDemo {

    private  ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public  void test1() {
        //ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) application.getBean("userService");
        userService.save();
    }

    @Test
    public  void test3() {
        Object userService = application.getBean("userService");
        System.out.println(userService);
    }

    @Test
    public void test4(){
        PersonDao personDao = application.getBean(PersonDao.class);
        System.out.println(personDao);
    }

    @Test
    public void test5(){
        UserDao userDao = application.getBean(UserDao.class);
        userDao.show();
    }


    @Test
    public void test2(){
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建一个读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取配置文件给工厂
        reader.loadBeanDefinitions("applicationContext.xml");
        //根据id创建bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        //System.out.println(userService);
        UserDao userDao = (UserDao) beanFactory.getBean("userDao");
        //System.out.println(userDao);
    }

    @Test
    public void testJdbc(){
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dataSource = application.getBean("dataSource");
        System.out.println(dataSource);
    }

    @Test
    public void testConnection(){
        Object connection = application.getBean("connection");
        System.out.println(connection);
    }

}
