package com.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Test2 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Random().nextInt(100000000));
        }

        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    if(iterator.next()>1000000){
                        iterator.remove();
                    }
                }
            }).start();
        }
    }

}
