package com.zhuzhe.Thread;

public class UseTheard extends Thread{

    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        new UseTheard().start();
        Thread.sleep(1000);
        System.out.println(3);
    }
}
