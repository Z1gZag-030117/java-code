package com.zhuzhe.Thread;

public class Ticket implements Runnable{

    private static Integer COUNT=50;

    String name;

    public Ticket(String name){
        this.name=name;
    }


    @Override
    public void run() {
        while(Ticket.COUNT>0){
            ThreadUtil.sleep(100);
            synchronized (Ticket.class){
                System.out.println(name+"出售一张票，还剩"+Ticket.COUNT--+"张票");
            }
        }
    }

    public static void main(String[] args) {

        Thread t1=new Thread(new Ticket("一号窗口"));
        Thread t2=new Thread(new Ticket("二号窗口"));

        t1.start();
        t2.start();
        ThreadUtil.sleep(10000);


    }



}
