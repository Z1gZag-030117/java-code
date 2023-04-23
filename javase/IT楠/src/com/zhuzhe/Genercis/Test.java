package com.zhuzhe.Genercis;

public class Test {
    public <T> T show(T t){
        System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        Test test=new Test();
        String str=test.show("hello");
        System.out.println(str);
    }

}
