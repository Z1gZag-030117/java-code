package com.zhuzhe.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerPlus {

    public static void main(String[] args) {
        HashMap<Integer,String> hashMap=new HashMap<>();
        ArrayList<Integer> array=new ArrayList<>();
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","k","A","2",};
        String[] colors={"♣","♦","♠","♥"};
        int index=0;
        for (String color:colors){
            for (String number:numbers){
                hashMap.put(index,color+number);
                array.add(index);
                index++;
            }
        }
        hashMap.put(index,"小王");
        array.add(index);
        index++;
        hashMap.put(index,"大王");
        array.add(index);

        Collections.shuffle(array);

        TreeSet<Integer> user1=new TreeSet<>();
        TreeSet<Integer> user2=new TreeSet<>();
        TreeSet<Integer> user3=new TreeSet<>();
        TreeSet<Integer> dp=new TreeSet<>();

        for (int i = 0; i < array.size(); i++) {
            Integer integer = array.get(i);
            if (i >= array.size()-3){
                dp.add(integer);
            }else if (i%3==0){
                user1.add(integer);
            }else if (i%3==1){
                user2.add(integer);
            }else if (i%3==2){
                user3.add(integer);
            }
        }

        show("zz",hashMap,user1);
        show("sn",hashMap,user2);
        show("01",hashMap,user3);
        show("底牌",hashMap,dp);
    }
    public static void show(String name,HashMap<Integer,String> hashMap,TreeSet<Integer> treeSet){
        System.out.print(name+" :");
        for (Integer i:treeSet){
            String poker=hashMap.get(i);
            System.out.print(poker+" ");
        }
        System.out.println();
    }




}
