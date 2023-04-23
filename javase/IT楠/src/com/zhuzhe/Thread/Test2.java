package com.zhuzhe.Thread;

public class Test2 {
    private static int COUNT=0;
    public synchronized static void adder(){
        COUNT++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });

        Thread t2=new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                adder();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(COUNT);


    }
}
