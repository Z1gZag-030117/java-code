package com.zz.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyAdvice3 implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前");
        Object result = methodInvocation.getMethod().invoke(methodInvocation.getThis(), methodInvocation.getArguments());
        System.out.println("环绕后");
        return result;
    }
}
