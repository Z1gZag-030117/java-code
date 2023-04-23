package com.zhuzhe.polymorphism;

public class Girl {

    public void feed(Pet pet){
        pet.eat();
    }



    public static void main(String[] args) {

        Girl girl=new Girl();

        Pet dog=new Dog();
        Pet cat=new Cat();

        girl.feed(dog);
        girl.feed(cat);


    }


}
