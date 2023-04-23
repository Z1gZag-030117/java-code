package com.Reflection;

/**
 * @author 朱喆
 * @version 1.0
 */
public class getClass {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. Class.forName
        String classAllPath ="com.Reflection.Car";
        Class cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2.类名.class  ，应用场景：用于参数传递
        Class cls2=String.class;
        System.out.println(cls2);

        //3. 对象.getClass, 应用场景：有对象实例
        Car car=new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4.通过类加载器获取类的Class对象
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);


    }
}
