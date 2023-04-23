package com.zz.processor;

import com.zz.advice.MyAdvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MockAopBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //目的：对UserServiceImpl中的show1和show2方法增强，增强方法在MyAdvice中
        //问题：1.筛选service.impl包下的所有方法都增强+
        //     2.如何获取MyAdvice 解决方法：从spring容器中获取
        if (bean.getClass().getPackage().getName().equals("com.zz.service.impl")) {
            //生成bean的proxy对象
            Object beanProxy = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        //执行增强对象的before方法
                        MyAdvice myAdvice = applicationContext.getBean(MyAdvice.class);
                        myAdvice.beforeAdvice();
                        //执行目标对象的目标方法
                        Object result = method.invoke(bean, args);
                        //执行增强对象的after方法
                        myAdvice.afterAdvice();
                        return result;
                    }
            );
            return beanProxy;
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
