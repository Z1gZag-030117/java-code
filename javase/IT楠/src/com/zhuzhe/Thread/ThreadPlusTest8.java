package com.zhuzhe.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadPlusTest8 implements Callable<Long> {
    public int from;
    public int to;

    public ThreadPlusTest8() {
    }

    public ThreadPlusTest8(int from, int to) {
        this.from = from;
        this.to = to;
    }

    Long res = 0L;

    @Override
    public Long call() throws Exception {
        for (int i = from; i < to; i++) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Long res = 0L;
        for (int i = 0; i < 200000000; i++) {
            res += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
        System.out.println("---------------");
        start = System.currentTimeMillis();
        res = 0L;
        FutureTask[] tasks = new FutureTask[10];
        for (int i = 0; i < 10; i++) {
            FutureTask<Long> futureTask = new FutureTask<>(new UseCallable(i * 20000000, (i + 1) * 20000000));
            new Thread(futureTask).start();
            tasks[i] = futureTask;
        }
        for (int i = 0; i < 10; i++) {
            Long sum = 0L;
            sum += (Long) tasks[i].get();
            res += sum;
        }
        end = System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end - start);
    }

}
