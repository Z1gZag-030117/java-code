package p223;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iterator {
    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();

        c.add("hello");
        c.add("word");
        c.add("java");

        Iterator<String> it = c.iterator();


        while(it.hasNext()){
            //System.out.println(it.next());
            String s=it.next();//拿到字符串之后可能还有操作
            System.out.println(s);
        }
    }
}
