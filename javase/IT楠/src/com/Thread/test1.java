package com.Thread;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test1 {
    public static void main(String[] args) {
        A a=new A();
        B b=new B(a);
        a.start();
        b.start();
    }
}

class A extends Thread {
    private boolean flag=true;
    @Override
    public void run() {
        while(flag){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A线程退出");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class B extends Thread{
    private A a;
    private Scanner scanner=new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("输入Q退出A线程");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key=='Q'){
                a.setFlag(false);
                System.out.println("B线程退出");
                break;
            }
        }
    }
}
