package com.zhuzhe.singleton;


public class Client {

    public static void main(String[] args) {

        SingletonHungry singleton= SingletonHungry.getInstance();
        SingletonHungry singleton2= SingletonHungry.getInstance();
        SingletonHungry singleton3= SingletonHungry.getInstance();


        System.out.println(singleton==singleton2);
        System.out.println(singleton2==singleton3);



    }
}
