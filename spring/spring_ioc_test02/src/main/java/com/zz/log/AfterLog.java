package com.zz.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author 朱喆
 * @version 1.0
 */
public class AfterLog implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+o1.getClass().getName()+"的"+method.getName()+"方法，"+"返回值："+o);
    }
}
