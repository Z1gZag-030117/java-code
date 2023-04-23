package com.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetTest {
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
        System.out.println(hashSet);

        System.out.println("-------------------------");

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
        System.out.println(list);

        System.out.println("----------------------");
        HashSet set=new HashSet();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);

    }
}
