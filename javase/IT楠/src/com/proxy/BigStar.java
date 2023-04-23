package com.proxy;

/**
 * @author 朱喆
 * @version 1.0
 */
public class BigStar implements Star{

    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String name){
        System.out.println(this.name+"sing" +name);
        return "thank";
    }

    public void dance(){
        System.out.println(this.name+"dance");
    }

}
