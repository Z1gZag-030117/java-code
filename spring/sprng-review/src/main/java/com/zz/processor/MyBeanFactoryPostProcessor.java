package com.zz.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("beanDefinitionMap填充完后回调该方法");
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
//        beanDefinition.setBeanClassName("com.zz.dao.impl.UserDaoImpl");
    }
}
