package com.zz.log;

/**
 * @author 朱喆
 * @version 1.0
 */
public class DiyPointcut {

    public void before(){
        System.out.println("执行方法之前");
    }

    public void after(){
        System.out.println("执行方法之后");
    }
}
