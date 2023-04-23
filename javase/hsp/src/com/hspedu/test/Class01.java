package com.hspedu.test;

import com.hspedu.Car;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Class01 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "com.hspedu.Car";
        //获取Car类对应的Class对象
        //Class<?> :<?> 表示不确定的Java类型
        Class cls = Class.forName(classAllPath);
        System.out.println(cls);//显示输出cls对象，是哪个类的Class对象
        System.out.println(cls.getClass());//输出cls的运行类型
        //获取包名
        System.out.println(cls.getPackage().getName());
        //获取类名
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);
        //获取cls的属性
        Field brand = cls.getField("brand");
        /*
            Field field1 = cls.getField("name");
            报错： NoSuchFieldException
            原因： name属性为private修饰
         */
        //给反射属性赋值
        brand.set(car, "宝马");
        System.out.println(brand.get(car));
        //获得全部属性
        System.out.println("------------");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

    }


}
