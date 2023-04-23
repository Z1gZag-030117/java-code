package com.zhuzhe.Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger=new AtomicInteger();

    public static void main(String[] args) {

        for (int i = 0; i < 200; i++) {
            new Thread(()->{
                ThreadUtil.sleep(20);
                atomicInteger.getAndIncrement();
            }).start();
        }

        ThreadUtil.sleep(2000);
        System.out.println(atomicInteger.get());

    }

}
