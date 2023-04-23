package com.zhuzhe.Thread;

import org.omg.IOP.TAG_JAVA_CODEBASE;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable implements Callable<Long> {

    private int from;
    private int to;

    public UseCallable() {
    }

    public UseCallable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        Long res=0L;
        for (int i = from; i <to; i++) {
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       long start=System.currentTimeMillis();
       Long res=0L;
        for (int i = 0; i < 100000000; i++) {
            res+=i;
        }
        long end=System.currentTimeMillis();

        System.out.println(end-start);
        System.out.println(res);


        start=System.currentTimeMillis();
        res=0L;
        FutureTask[] futureTask=new FutureTask[10];
        for (int i = 0; i < 10; i++) {
            FutureTask<Long> task=new FutureTask<>(new UseCallable(i*10000000,(i+1)*10000000));
            new Thread(task).start();
            futureTask[i]=task;
        }
        for (int i = 0; i < futureTask.length; i++) {
            Long sum = (Long)futureTask[i].get();
            res+=sum;
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(res);


    }



}
