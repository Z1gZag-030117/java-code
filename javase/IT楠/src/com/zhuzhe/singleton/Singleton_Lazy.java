package com.zhuzhe.singleton;

public class Singleton_Lazy {

    private static Singleton_Lazy INSTANCE=null;

    private Singleton_Lazy(){}


    public static Singleton_Lazy getInstance(){
        if (INSTANCE==null){
            INSTANCE=new Singleton_Lazy();
        }
        return INSTANCE;
    }


}
