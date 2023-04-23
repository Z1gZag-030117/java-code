package com.zhuzhe.Thread;

public class ThreadUtil {

    public static void sleep(int time)  {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
