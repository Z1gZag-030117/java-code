package com.zz.advice;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MyAdvice {

    public void beforeAdvice() {
        System.out.println("前置增强");
    }

    public void afterAdvice() {
        System.out.println("后置增强");
    }
}
