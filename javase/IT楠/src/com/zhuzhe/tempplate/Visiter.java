package com.zhuzhe.tempplate;

public class Visiter {

    public void visit(Prisoner prisoner){
        System.out.println("---------开始体验罪犯");
        prisoner.life();
        System.out.println("--------结束一天");
    }

    public static void main(String[] args) {
        Visiter visiter=new Visiter();
        Prisoner wyf=new StarPrisoner("吴亦凡");
        Prisoner zs=new PolitcalPrisoner("张三");
        visiter.visit(wyf);
        visiter.visit(zs);
    }

}
