package com.hspedu;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InstantiationException {
        //test1();
        test2();
        //test3();
    }

    public static void test1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999990; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("test1:  " + (end - start));
    }

    public static void test2() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method = cls.getMethod(methodName);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999990; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("test2:  " + (end - start));
    }

    public static void test3() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.setAccessible(true);//取消反射调用方法时访问检测
        long start = System.currentTimeMillis();
        for (int i = 0; i < 999999990; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("test2:  " + (end - start));
    }

}
