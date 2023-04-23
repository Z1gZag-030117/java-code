package com.Reflection;

import java.lang.reflect.Field;

/**
 * @author 朱喆
 * @version 1.0
 */
public class class_ {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classFullPath="com.Reflection.Car";
        Class cls = Class.forName(classFullPath);
        System.out.println(cls);  //显示cls对象，是哪个类的Class对象 com.Reflection.Car
        System.out.println(cls.getClass());  //输出cls的运行类型 java.lang.Class
        System.out.println(cls.getPackage());//包名
        System.out.println(cls.getName());//得到的全类名

        Object o = cls.newInstance();
        System.out.println(o);

        Field brand = cls.getField("brand");
        System.out.println(brand.get(o));

        brand.set(o,"111");
        System.out.println(brand.get(o));



    }
}
