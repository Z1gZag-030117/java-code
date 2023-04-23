package com.zhuzhe.ThreadPool;

import com.zhuzhe.Thread.ThreadUtil;

public class MyTask implements Runnable{
    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        System.out.println("线程:"+name+"即将执行任务:"+id);
        ThreadUtil.sleep(200);
        System.out.println("线程:"+name+"完成了任务:"+id);

    }
}
