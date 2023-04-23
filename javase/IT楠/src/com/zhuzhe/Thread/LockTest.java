package com.zhuzhe.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static final Lock lock=new ReentrantLock();
    private static final LockTest test=new LockTest();

    public void say(){
        lock.lock();
        try {
            ThreadUtil.sleep(100);
            System.out.println("hello");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                test.say();
                System.out.println(Math.random());
            }).start();
        }
    }

}
