package com.zhuzhe.tempplate;

public class PolitcalPrisoner extends Prisoner{

    private String name;
    public PolitcalPrisoner(String name){
        this.name=name;
    }

    @Override
    void work() {
        System.out.println("政治罪犯再劳动");
    }

    @Override
    void eat() {
        System.out.println("政治罪犯再吃饭");
    }

    @Override
    void watchNews() {
        System.out.println("政治罪犯在看新闻");
    }
}
