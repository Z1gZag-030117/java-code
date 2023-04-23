package com.zhuzhe.polymorphism;

public class Computer {
    public int plus(int i,int j){
        return i+j;
    }

    public static void main(String[] args) {
        Computer computer=new Computer();
        System.out.println(computer.plus(2,3));
    }
}
