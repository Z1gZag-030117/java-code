package com.zhuzhe.singleton;

public class SingletonHungry {

    private final static SingletonHungry INATANCE=new SingletonHungry();

    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return INATANCE;
    }


}
