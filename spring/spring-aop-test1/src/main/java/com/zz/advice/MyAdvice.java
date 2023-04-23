package com.zz.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 朱喆
 * @version 1.0
 */
//增强类，提供增强方法
@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.zz.service.impl.*.*(..))")
    public void myPoint() {
    }


    //<aop:before method="beforeAdvice" pointcut-ref="execution(void com.zz.service.impl.UserServiceImpl.show1())"/>-->
    @Before("execution(void com.zz.service.impl.UserServiceImpl.show2())")
    public void beforeAdvice() {
        System.out.println("前置增强");
    }

    public void afterAdvice() {
        System.out.println("后置增强");
    }

    //@Around("execution(* com.zz.service.impl.UserServiceImpl.show1())")
    @Around("MyAdvice.myPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前的增强");
        Object proceed = proceedingJoinPoint.proceed();//执行目标方法
        System.out.println("环绕后的增强");
        return proceed;
    }

    public void afterThrowingAdvice() {
        System.out.println("异常抛出通知。。。。。报异常才执行");
    }

    public void finalAdvice() {
        System.out.println("最终通知");
    }


}
