package com.zhuzhe.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<>(new CallableTest());
        new Thread(futureTask).start();

        //阻塞
        Integer integer=futureTask.get();
        System.out.println(integer);
    }




}
