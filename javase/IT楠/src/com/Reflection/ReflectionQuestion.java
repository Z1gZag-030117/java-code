package com.Reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 朱喆
 * @version 1.0
 */
@SuppressWarnings("all")
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath="+classfullpath);
        System.out.println("methodName="+methodName);

        //加载类，返回Class类的对象cls
        Class cls = Class.forName(classfullpath);
        //通过cls得到加载的类com.Reflection.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o 的运行类型"+o.getClass());
        //通过cls得到加载的类com.Reflection.Cat的methodName “hi” 的方法对象
        Method method1 = cls.getMethod(methodName);
        //通过method1 来调用方法
        method1.invoke(o);


    }

}
