package 并发修改异常;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class list {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();

        list.add("hello");
        list.add("word");
        list.add("java");

//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String s=it.next();
//            if(s.equals("word")){
//                list.add("fuck");
//            }
//        }
        ListIterator<String> lit = list.listIterator();
        while(lit.hasNext()){
            String s=lit.next();
            if(s.equals("word")){
                lit.add("javaee");
            }

        }
        System.out.println(list);



    }
}
