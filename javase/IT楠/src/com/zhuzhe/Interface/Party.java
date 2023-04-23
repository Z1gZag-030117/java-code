package com.zhuzhe.Interface;

public class Party {

    public void play(Human human){
        human.play();
    }


    public static void main(String[] args) {

        Party party=new Party();

        Human man=new Man();
        party.play(man);

        Human woman=new Woman();
        party.play(woman);

        int i=0;

        party.play(new Human() {
            @Override
            public void play() {
                System.out.println(i);
                System.out.println("animal is playing");
            }
        });

    }



}
