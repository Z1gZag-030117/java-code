package com.zz.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName+"postProcessBeforeInitialization");
//        return null;
//    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName+"postProcessAfterInitialization");
        Object beanProxy = Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(method.getName() + new Date());
                    Object invoke = method.invoke(bean, args);
                    System.out.println(method.getName() + new Date());
                    return invoke;
                }
        );
        return beanProxy;
    }
}
