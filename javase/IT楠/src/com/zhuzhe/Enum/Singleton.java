package com.zhuzhe.Enum;

public class Singleton {

    private Singleton() {
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANT.singleton;
    }

    private enum SingletonHolder{
        INSTANT;
        private Singleton singleton;

        SingletonHolder(){
            this.singleton=new Singleton();
        }
    }


}
