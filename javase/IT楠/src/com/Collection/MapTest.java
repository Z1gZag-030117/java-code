package com.Collection;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String,User> map=new HashMap<>();
        map.put("1",new User("zz1",1));
        map.put("2",new User("zz2",2));
        map.put("3",new User("zz3",3));
        map.put("4",new User("zz4",4));
        map.put("4",new User("zz4",4));

        //System.out.println(map.get("2"));
        System.out.println(map);
        System.out.println(map.keySet());
    }

}
