package com.zhuzhe.Interface;

/**
 * 有抽象方法的类，必须被声明为抽象类
 */
public abstract class Animal {

    protected String name;

    public Animal(){
        System.out.println("animal");  //抽象类不能直接被构造，但是可以通过子类构造
        this.name="zhuzhe";
    }

    abstract void eat(); //没有方法体

    public static void main(String[] args) {

        Animal dog = new Dog();
        dog.eat();

    }

}
