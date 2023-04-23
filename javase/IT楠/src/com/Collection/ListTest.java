package com.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("e");
        list.add("e");
        list.add("e");
        list.add("l");
        list.add("m");
        list.add("n");
        list.add("x");
        list.add("y");
        list.add("z");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next=iterator.next();
            System.out.println(next);
        }


    }

}
