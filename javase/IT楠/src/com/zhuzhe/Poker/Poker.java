package com.zhuzhe.Poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Poker {

    public static void main(String[] args) {
        String[] number={"A","2","3","4","5","6","7","8","9","10","J","Q","k"};
        String[] color={"♣","♦","♠","♥"};
        ArrayList<String> box=new ArrayList();
        for (String num:number){
            for (String col:color){
                box.add(col+num);
            }
        }
        box.add("大王");
        box.add("小王");

        Collections.shuffle(box);

        ArrayList<String> user1=new ArrayList();
        ArrayList<String> user2=new ArrayList();
        ArrayList<String> user3=new ArrayList();
        ArrayList<String> dp=new ArrayList();

        for (int i = 0; i < box.size(); i++) {
            String s = box.get(i);
            if (i> box.size()-3){
                dp.add(s);
            }else if (i%3==0){
                user1.add(s);
            }else if (i%3==1){
                user2.add(s);
            }else if (i%3==2){
                user3.add(s);
            }
        }

        show("zz",user1);
        show("sn",user2);
        show("01",user3);



    }

    public static void show(String name,ArrayList<String> arrayList){
        System.out.print(name+" : ");
        for (String s:arrayList){
            System.out.print(s+",");
        }
        System.out.println();
    }

}
