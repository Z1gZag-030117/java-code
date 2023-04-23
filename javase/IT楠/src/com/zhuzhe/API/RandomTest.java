package com.zhuzhe.API;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
//        Random random=new Random();
//        int i = random.nextInt(100);
//        System.out.println(i);
//
//        byte[] bytes=new byte[10];
//        random.nextBytes(bytes);
//        System.out.println(Arrays.toString(bytes));
//
//        random.ints(10).forEach(item-> System.out.println(item));

        for (int i = 0; i < 5; i++) {
            Random random=new Random();
            for (int j = 0; j < 5; j++) {
                System.out.print(random.nextInt(100)+",");
            }
            System.out.println("");
        }

        System.out.println("----------------------------------");

        for (int i = 0; i < 5; i++) {
            Random random=new Random(50);
            for (int j = 0; j < 5; j++) {
                System.out.print(random.nextInt(100)+",");
            }
            System.out.println("");
        }





    }
}
