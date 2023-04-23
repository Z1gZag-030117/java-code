package com.zhuzhe.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task=()->{
            ThreadUtil.sleep(2000);
            System.out.println("----------");
        };

        for (int i = 0; i < 200; i++) {
            executorService.submit(task);
        }

    }

}
