package com.zhuzhe.Thread;

public class UseRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        System.out.println(1);
        new Thread(()->System.out.println(4)).start();
        System.out.println(3);
    }

}
