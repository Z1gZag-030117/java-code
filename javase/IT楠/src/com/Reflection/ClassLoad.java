package com.Reflection;

/**
 * @author 朱喆
 * @version 1.0
 * 类加载的链接阶段-准备
 */
public class ClassLoad {
    public static void main(String[] args) {

        // new B
        System.out.println(B.num); //100，直接使用类的静态属性 ，也会导致类的加载
        
    }
}

//类加载的链接-准备阶段 属性的处理
class A{
    //1.n1是实例属性，不是静态变量，在此准备阶段，不会分配内存
    //2.n2是静态变量，分配内存 n2 默认初始化0，而不是20
    //3.n3 是static final 是常量， 他和静态变量不一样，因为一旦赋值就不变化 n3=30
    public int n1=10;
    public static int n2=20;
    public static final int n3=30;
}

class B{
    static {
        System.out.println("B的静态代码块执行");
    }
    static int num=100;
    public B() {
        System.out.println("B() 构造器执行");
    }
}
