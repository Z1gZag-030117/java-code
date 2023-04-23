package com.Collection;

import java.util.ArrayList;

public class Test  {


    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");

        ArrayList<String> list2=new ArrayList<>();
        list2.add("c");
        list2.add("d");

        list.addAll(2,list2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
