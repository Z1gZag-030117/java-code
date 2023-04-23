package p257;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        //创建集合
        Map<String,String> map=new HashMap<String,String>();

        map.put("1","11");
        map.put("2","22");
        map.put("3","33");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String > s:entrySet){
            String key = s.getKey();
            String value = s.getValue();
            System.out.println(key+","+value);
        }


//        //获取所有键的集合，用keyset（）方式
//        Set<String> keySet = map.keySet();
//        //遍历键的集合，获取每一个键
//        for (String key:keySet){
//            //使用键去寻找每一个值，用get方法
//            String value = map.get(key);
//            System.out.println(key+","+value);
//
//        }

//        //keyset 获取map集合中所有键的方法
//        Set<String> keySet = map.keySet();
//        for(String key: keySet){
//            System.out.println(key);
//        }
//
//        System.out.println("--------");
//
//        Collection<String> values = map.values();
//        for(String key:values){
//            System.out.println(key);
//        }
//
//
////        System.out.println(map.get("1"));
////        System.out.println(map.get("4"));

    }
}
