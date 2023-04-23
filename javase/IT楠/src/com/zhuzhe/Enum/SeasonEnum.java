package com.zhuzhe.Enum;

import java.util.Scanner;

public enum SeasonEnum {

    SPRING("春天","春天好"),
    SUMMER("xiaotian","xiatianhao"),
    AUTUMN("qiutian","qiutianhao"),
    WINTER("dongtian","dontianbuhao");
    private String name;
    private String detial;

    SeasonEnum() {
    }

    SeasonEnum(String name, String detial) {
        this.name = name;
        this.detial = detial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

    public static void test(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("春天了");
                break;
            case SUMMER:
                System.out.println("下天了");
                break;
            case AUTUMN:
                System.out.println("求天了");
                break;
            case WINTER:
                System.out.println("冬天了");
                break;

        }
    }

    public static void main(String[] args) {
//        SeasonEnum[] values = SeasonEnum.values();
//        SeasonEnum spring = SeasonEnum.valueOf("SPRING");
//        System.out.println(spring);
//
//        for (int i = 0; i < values.length; i++) {
//            System.out.println(values[i].detial);
//            System.out.println(values[i].name);
//        }
        test(SeasonEnum.AUTUMN);



    }
}
