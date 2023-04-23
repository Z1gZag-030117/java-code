package com.zhuzhe.Interface;

public class Dog extends Animal{

    @Override
    void eat() {
        System.out.println( this.name+"is eating");//自己没有name，去父类找，父类被构造的时候，name为zhuzhe
    }

}
