package com.zhuzhe.Thread;

public class ThreadWait {
    public static Object MONITOR=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (MONITOR){
                System.out.println("线程1开始");
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1结束");
            }
        }).start();

        new Thread(()->{
            synchronized (MONITOR){
                System.out.println("线程2开始");
                ThreadUtil.sleep(2000);
                MONITOR.notify();
                System.out.println("线程2结束");
            }

        }).start();
    }

}
