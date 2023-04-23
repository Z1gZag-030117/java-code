package com.zhuzhe.polymorphism;

public class Dog extends Pet{

    @Override
    public void eat() {
        System.out.println("Dog eating");
    }

    @Override
    public void eat(String food){
        System.out.println("Dog eating "+food);
    }

    public static void main(String[] args) {
        Pet pet=new Dog();
        pet.eat("meet");

    }
}
