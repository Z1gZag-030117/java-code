package com.zhuzhe.Thread;

public class TestJoin {
    public static void main(String[] args) {

        Thread t1=new Thread(()->{
            ThreadUtil.sleep(2000);
            System.out.println("t1--------");
        });

        Thread t2=new Thread(()->{
            ThreadUtil.sleep(3000);
            System.out.println("t2--------");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main--------");


    }
}
