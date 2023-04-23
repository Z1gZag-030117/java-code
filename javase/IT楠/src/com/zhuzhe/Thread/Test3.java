package com.zhuzhe.Thread;

public class Test3 {

    private static int number=0;
    private static final ThreadLocal<Integer> threadLocal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(number);//将number保存到这个线程里
                for (int i = 0; i < 1000; i++) {
                    threadLocal.set(threadLocal.get()+1);
                    System.out.println("t1----:"+threadLocal.get());
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(number);
                for (int i = 0; i < 1000; i++) {
                    threadLocal.set(threadLocal.get()+1);
                    System.out.println("t2----:"+threadLocal.get());
                }
            }
        });

        t1.start();
        t2.start();

    }

}
