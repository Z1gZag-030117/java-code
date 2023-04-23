package com.Reflex;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexTest {

    //使用类名获取
    Class<Dog> class1 = Dog.class;


    @Test
    public void CreateClass() {
        //使用类名获取
        Class<Dog> class1 = Dog.class;
        //使用对象获取
        Dog dog=new Dog();
        Class<? extends Dog> class2 = dog.getClass();
        //使用forname，全限定名称
        Class<?> class3 = null;
        try {
            class3 = Class.forName("com.Reflex.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(class1==class2);
        System.out.println(class1==class3);
    }

    @Test
    public void FieldTest() throws NoSuchFieldException, IllegalAccessException {
        Dog dog=new Dog();
        Field name = class1.getDeclaredField("name");
        //直接设置值不能是private
        //暴力注入
        name.setAccessible(true);
        name.set(dog,"zz");
        System.out.println(dog.getName());
        Object o = name.get(dog);
        System.out.println(o);
    }

    @Test
    public void methodTest(){
        Method[] methods = class1.getMethods();
        Method[] declaredMethods = class1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method.getName() = " + method.getName());
        }
        System.out.println("-----------------------------------");
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());
        }
    }

    @Test
    public void methodTest2() throws NoSuchMethodException {
        Method method=class1.getDeclaredMethod("eat");
        Method method2=class1.getDeclaredMethod("eat",String.class);

    }

    @Test
    public void constructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Dog> declaredConstructor = class1.getDeclaredConstructor();
        Dog dog = declaredConstructor.newInstance();//new Dog() ;

        Constructor<Dog> declaredConstructor1 = class1.getDeclaredConstructor(String.class,int.class);
        Dog dog1 = declaredConstructor1.newInstance("sn", 111);
        System.out.println(dog1);
    }

}
