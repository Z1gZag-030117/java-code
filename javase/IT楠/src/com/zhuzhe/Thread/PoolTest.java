package com.zhuzhe.Thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random=new Random();
        Runnable runnable=() ->{System.out.println(random.nextInt());ThreadUtil.sleep(500);};
        for (int i = 0; i < 100; i++) {
            executorService.submit(runnable);
        }
    }

}
