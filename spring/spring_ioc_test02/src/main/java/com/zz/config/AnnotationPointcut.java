package com.zz.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 朱喆
 * @version 1.0
 */
@Component
@Aspect
public class AnnotationPointcut {
    @Pointcut("execution(* com.zz.service.impl.*.*(..))")
    public void point(){}


    @Before("AnnotationPointcut.point()")
    public void before(){
        System.out.println("---------方法执行前---------");
    }

    @After("AnnotationPointcut.point()")
    public void after(){
        System.out.println("---------方法执行后---------");
    }

    @Around("AnnotationPointcut.point()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名:"+jp.getSignature());
        //执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }

}
