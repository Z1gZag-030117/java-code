package day7;

import java.util.ArrayList;

public class demo {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();

        //将指定元素添加到集合尾
        //System.out.println(arr.add("hello"));
        arr.add("hello");
        arr.add("word");
        arr.add("java");

        //在集合中的指定位置添加元素
        //arr.add(1,"javaaaaa");
        System.out.println(arr.get(3));
        //输出集合
        System.out.println("Array:" +arr);
    }
}
