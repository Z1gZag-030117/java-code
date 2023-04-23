package com.zhuzhe.InnerClass;

public class Outer {
    public int number=1;
    private static int number2=2;

    public void test1(){
        new Inner();
    }

    public class Inner{  //内部类


        public Inner() {
            System.out.println(number);
            System.out.println(number2);
        }

    }

    public static void main(String[] args) {
        new Outer().test1();
    }
}
