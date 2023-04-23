package com.zhuzhe.Thread;

public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName()+":"+i);
        }
    }


}
//    public Thread() {
//        init(null, null, "Thread-" + nextThreadNum(), 0);
//    }
//private static int threadInitNumber;
//    private static synchronized int nextThreadNum() {
//        return threadInitNumber++;
//    }

