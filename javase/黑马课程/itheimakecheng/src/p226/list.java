package p226;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();

        list.add("hello");
        list.add("word");
        list.add("java");
        list.add("java");

//        System.out.println(list);
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String s=it.next();
            System.out.println(s);
        }

    }
}
