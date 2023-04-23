package com.Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkHashMapTest {

    public static void main(String[] args) {



        Map<String,String> map=new LRU<>();
        map.put("v","abc");
        map.put("b","abc");
        map.put("e","abc");
        map.put("y","abc");
        map.put("m","abc");
        map.put("f","abc");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


    }

}
