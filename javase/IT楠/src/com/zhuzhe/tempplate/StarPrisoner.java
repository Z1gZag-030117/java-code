package com.zhuzhe.tempplate;

public  class StarPrisoner extends Prisoner {

    private String name;

    public StarPrisoner(String name){
        this.name=name;
    }


    @Override
    void work() {
        System.out.println(this.name+"边唱歌边劳动");
    }

    @Override
    void eat() {
        System.out.println(this.name+"边唱歌边吃饭");
    }

    @Override
    void watchNews() {
        System.out.println(this.name+"边唱歌边看新闻");
    }
}
