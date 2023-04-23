package com.zhuzhe.Lock;

import com.zhuzhe.Thread.ThreadUtil;

public class Test {

    private static final Object MONITOR=new Object();
    private static final Test test=new Test();

    public void say1(){
        synchronized (this) {
            ThreadUtil.sleep(100);
            System.out.println("hello");
        }
    }

    public static synchronized void say2(){
        ThreadUtil.sleep(100);
        System.out.println("say2");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(()-> {
                //say1是实例方法，synchronized锁的是this
                //每new一个线程，都会创建一个新的实例对象
                //每调用一个方法，锁的都是this本身
                //Test test=new Test();
                test.say1();
                System.out.println(Math.random()+"--------------");
            }).start();
        }

//        for (int i = 0; i < 50; i++) {
//            new Thread(()-> {
//                say2();
//                System.out.println(Math.random()+"--------------");
//            }).start();
//        }
//
//        for (int i = 0; i < 50; i++) {
//            new Thread(()-> {
//                ThreadUtil.sleep(100);
//                synchronized (MONITOR){
//                    System.out.println("zz");
//                    System.out.println(Math.random());
//                }
//            }).start();
//        }

    }


}
