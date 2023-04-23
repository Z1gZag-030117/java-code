package com.zhuzhe.block;

public class Test {

    public static String name="zhuzhe";
    public String name2="sn";

    public static void print(){
        System.out.println("hello");
    }


    /**\
     * 静态方法调用：类名.方法名
     * 静态变量调用：类名.变量名
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Test.name);
        Test.print();
    }


}
