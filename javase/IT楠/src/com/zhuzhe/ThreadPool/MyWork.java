package com.zhuzhe.ThreadPool;

import java.util.List;

public class MyWork extends Thread{

    private String name;
    private List<Runnable> tasks;

    public MyWork(String name, List<Runnable> tasks) {
        super(name);
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while(tasks.size()>0){
            Runnable remove = tasks.remove(0);
            remove.run();
        }
    }
}
