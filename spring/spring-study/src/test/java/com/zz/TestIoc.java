package com.zz;

import com.zz.service.OrderService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 朱喆
 * @version 1.0
 */
public class TestIoc {

    private static final Logger log= LoggerFactory.getLogger(testContainer.class);




    @Test
    public void testIoc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        UserDaoImpl userDaoImpl = (UserDaoImpl) context.getBean("userDao");
        userDaoImpl.hello();
    }

    @Test
    public void testIoc2(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("ioc.xml");
        UserDaoImpl userDaoImpl = beanFactory.getBean(UserDaoImpl.class);
        Object userDao1 = beanFactory.getBean("userDao");
        System.out.println(userDaoImpl);
        System.out.println(userDao1);
    }

    @Test
    public void testGirl(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        Object girl = context.getBean("girl");
        System.out.println(girl.toString());
    }

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
        UserDaoImpl UserDaoImpl = (UserDaoImpl)context.getBean("userService");
        log.info(UserDaoImpl.toString());
    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ioc.xml");
        UserDaoImpl userDaoImpl = (UserDaoImpl)context.getBean("userDao");
        userDaoImpl.hello();
    }

    /**
     *构造器注入
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        //userService.hello();
    }

    @Test
    public void  testAware(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aware.xml");
        A a = context.getBean(A.class);
        a.printName();
        log.info("{}",a );
    }

    @Test
    public void  testAnnotation(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
        Boy boy = context.getBean(Boy.class);
        log.info("{}",boy );
        System.out.println(boy.toString());
    }

    @Test
    public void testScan(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("scan.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        log.info("{}",orderService);
    }

    @Test
    public void testScan2(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.zz");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        log.info("{}",orderService);
    }

}
