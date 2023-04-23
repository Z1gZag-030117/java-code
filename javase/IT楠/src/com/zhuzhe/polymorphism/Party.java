package com.zhuzhe.polymorphism;

public class Party {

    public void play(Human human){
        System.out.println("human");
    }

    public void play(Man man){
        System.out.println("man");
    }

    public void play(Woman woman){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Party party=new Party();

        Human human=new Human();
        party.play(human);

        Human man=new Man();
        party.play(man);

        Human woman=new Woman();
        party.play(woman);


    }

}
