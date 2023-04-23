package p221;


import java.util.ArrayList;

public class Collection {
    public static void main(String[] args) {

        java.util.Collection<String> c=new ArrayList<String>();

        c.add("hello");
        c.add("word");
        c.add("java");

//        System.out.println(c.remove("hello"));

//        c.clear();
        System.out.println(c.contains("hello"));//判断集合中是否有hello这个元素

        System.out.println(c.isEmpty());//判断集合是否为空

        System.out.println(c);
    }


}
