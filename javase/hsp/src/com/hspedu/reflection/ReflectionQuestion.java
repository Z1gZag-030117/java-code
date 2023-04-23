package com.hspedu.reflection;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ReflectionQuestion {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath:" + classfullpath);
        System.out.println("method:" + methodName);

        //1.加载类 返回Class类的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls的newInstance方法获取com.hspedu.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //3.通过cls的getMethod方法 获取加载类（com.hspedu.Cat）的方法名（methodName）为hi的方法
        Method method = cls.getMethod(methodName);
        /*4.通过method调用方法(通过方法对象来实现调用方法)

            传统 通过对象调用方法：  对象.方法()
            Cat cat = new Cat();
            cat.hi();
            -------------------------
            反射： 方法.invoke(对象)
         */
        method.invoke(o);
        /*
            传统：修改源码来调用不同方法
            cat.hi ==> cat.cry

            反射：修改配置文件来调用不同方法(无需修改源代码 )
         */



        /*
        Field name = cls.getField("name");
        报错：NoSuchFieldException
        原因：getField不能获取私有的属性
        */
        Field age = cls.getField("age");
        System.out.println(age.get(o));

        Constructor constructor = cls.getConstructor();//（）中可以指定构造器的类型
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }

}
