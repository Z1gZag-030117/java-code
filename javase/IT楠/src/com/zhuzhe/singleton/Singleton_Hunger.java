package com.zhuzhe.singleton;

public class Singleton_Hunger {

    private static Singleton_Hunger INSTANCE=new Singleton_Hunger();

    private Singleton_Hunger() {
    }

    public static Singleton_Hunger getInstance(){
        return INSTANCE;
    }


}
