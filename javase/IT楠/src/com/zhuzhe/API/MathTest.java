package com.zhuzhe.API;

import java.math.BigDecimal;

public class MathTest {
    public static void main(String[] args) {
//        System.out.println(Math.floor(2.333));
//        System.out.println(Math.ceil(2.3333));
//        System.out.println(Math.round(2.333));

        BigDecimal bigDecimal=new BigDecimal("0.1");
        BigDecimal add = bigDecimal.add(new BigDecimal("0.2"));
        System.out.println(add);


    }
}
