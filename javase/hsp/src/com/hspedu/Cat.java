package com.hspedu;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Cat {

    private String name = "sn";
    public int age = 10;

    public Cat() {

    }

    public Cat(String name) {
        name = this.name;
    }

    public void hi() {
        System.out.println("hi");
        int i = 1, j = 1, res;
        res = i + j;
    }

    public void cry() {
        System.out.println("cry");
    }

}
