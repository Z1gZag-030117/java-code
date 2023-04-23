package com.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 朱喆
 * @version 1.0
 */
public class teat {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class<PrivateTest> privateTestClass = PrivateTest.class;
        PrivateTest privateTest = privateTestClass.newInstance();
        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest,"zz");
        Method getName = privateTestClass.getMethod("getName");
        Object invoke = getName.invoke(privateTest);
        System.out.println(invoke);
    }
}

class PrivateTest{
    private String name="hello";

    public String getName() {
        return name;
    }

}
