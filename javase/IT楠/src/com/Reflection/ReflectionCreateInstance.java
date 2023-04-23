package com.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String classPath="com.Reflection.User";
        Class<?> cls = Class.forName(classPath);
        Object o = cls.newInstance();
        System.out.println(o);


        Constructor<?> constructor = cls.getConstructor(String.class);
        Object zz = constructor.newInstance("zz");
        System.out.println("zz="+zz);

        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);
        Object sn = declaredConstructor.newInstance(20, "sn");
        System.out.println(sn);
    }
}

class User{
    public int age=10;
    public String name="zz";

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
