package com.zhuzhe.Thread;

public class Test {

    public volatile static boolean flag=false;

    public static void main(String[] args) {
        new Thread(()->{
            while(!flag){}
            System.out.println("看见");
        }).start();

        ThreadUtil.sleep(2000);
        flag=true;


    }

}
