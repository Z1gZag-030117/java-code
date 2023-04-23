package p238;

import java.util.HashSet;
import java.util.Iterator;

public class Set {
    public static void main(String[] args) {
        //创建set集合对象
        java.util.Set<String> set=new HashSet<String>();
        //添加元素
        set.add("hello");
        set.add("word");
        set.add("java");
//        set.add("hello");

        //输出
        for(String s:set){
            System.out.println(s);
        }

        System.out.println("--------");

        Iterator<String> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
