package com.zhuzhe.Sort;

import java.util.Random;

public class QuickSortTest {

    public static void main(String[] args) {

        int[] arr=new int[1000000];
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt();
        }
        long s=System.currentTimeMillis();
        QuickSort.quick_sort(arr,0,arr.length-1);
        long e=System.currentTimeMillis();
        System.out.println(e-s);


        s=System.currentTimeMillis();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]<arr[j+1]){
                    int temp;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        e=System.currentTimeMillis();
        System.out.println((e-s)/1000+"秒");


    }

}
