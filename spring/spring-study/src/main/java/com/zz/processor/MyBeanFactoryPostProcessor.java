package com.zz.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanDefinitionMap填充完毕后spring回调该方法");

        //注册beanDefinition
//        BeanDefinition beanDefinition=new RootBeanDefinition();
//        beanDefinition.setBeanClassName("com.zz.PersonDao");//创建一个beanDefinition
//        DefaultListableBeanFactory defaultListableBeanFactory= (DefaultListableBeanFactory) beanFactory;
//        defaultListableBeanFactory.registerBeanDefinition("personDao",beanDefinition);//注册一个beanDefinition


        /*
        // 在生成beanDefinitionMap之后，生成singletonObject之前执行该方法
        BeanDefinition bean = beanFactory.getBeanDefinition("userService");
        //修改beanDefinition
        //设置bean的类路径为com.zz.UserDao，在生成singletonObject时将会生成UserDao
        bean.setBeanClassName("com.zz.UserDao");
         */
    }
}
