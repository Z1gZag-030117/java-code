package com.Collection;

import java.util.HashSet;
import java.util.Iterator;

public class IterateTest {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("e");
        hashSet.add("e");
        hashSet.add("e");
        hashSet.add("l");
        hashSet.add("m");
        hashSet.add("n");
        hashSet.add("x");
        hashSet.add("y");
        hashSet.add("z");

        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            String next=iterator.next();
            System.out.println(next);
        }
    }
}
