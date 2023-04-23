package com.zhuzhe.singleton;

public class Singleton3 {

    private static Singleton3 INSTANT;

    private Singleton3(){

    }


    //获取实例
    public static Singleton3 getInstance(){
        return SingletonHolder.INSTANT;
    }

    //静态内部类第一次被调用时加载一次，静态常量在静态内部类加载的时候初始化一次
    private static class SingletonHolder{

        private static final Singleton3 INSTANT=new Singleton3();

    }


}
