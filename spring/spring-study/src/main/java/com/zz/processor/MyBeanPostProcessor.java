package com.zz.processor;

import com.zz.UserDaoImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof UserDaoImpl){
            UserDaoImpl userDaoImpl = (UserDaoImpl) bean;
            //userDaoImpl.setUsername("sn");
        }
        System.out.println(beanName+" : postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+" : postProcessAfterInitialization");
        return bean;
    }
}
