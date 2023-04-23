package com.zhuzhe.Thread;

public class Test4 {
    public static void main(String[] args) {
        MyThread thread1=new MyThread("zhuzhe");
        MyThread thread2=new MyThread("sn");
        MyThread thread3=new MyThread("01");

        System.out.println(Thread.MAX_PRIORITY);//10
        System.out.println(Thread.MIN_PRIORITY);//1
        System.out.println(Thread.NORM_PRIORITY);//5

        //机率高
        thread1.setPriority(2);
        thread2.setPriority(5);
        thread3.setPriority(10);

//        System.out.println(thread1.getPriority());
//        System.out.println(thread2.getPriority());
//        System.out.println(thread3.getPriority());

        thread1.start();
        thread2.start();
        thread3.start();

        //System.out.println(Thread.currentThread().getName());
    }

}
