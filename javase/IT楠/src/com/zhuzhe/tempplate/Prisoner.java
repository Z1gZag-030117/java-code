package com.zhuzhe.tempplate;

public abstract class Prisoner {

    protected String name;
    /**
     * 劳动方法
     */
    abstract void work();

    /**
     * 吃饭方法
     */
    abstract void eat();

    /**
     * 看新闻
     */
    abstract void watchNews();

    /**
     * 一天的生活
     */

    public void life(){
        eat();
        work();
        eat();
        work();
        watchNews();
    }



}
