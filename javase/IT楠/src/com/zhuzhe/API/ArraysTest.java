package com.zhuzhe.API;

import java.util.Arrays;
import java.util.Random;

public class ArraysTest {

    public static void main(String[] args) {
        int[] ints=new int[1000000];
        Random random=new Random();
        for (int i = 0; i < 1000000 ; i++) {
            ints[i]=random.nextInt();
        }

        long start=System.currentTimeMillis();
        Arrays.sort(ints);
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }

}
