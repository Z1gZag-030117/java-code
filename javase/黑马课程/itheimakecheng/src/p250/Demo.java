package p250;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {

        Collection<String> c=new ArrayList<String>();

        c.add("zz");
        c.add("sn");
        c.add("ssnn");

        Iterator<String> it = c.iterator();

        while(it.hasNext()){
//            Object o = it.next();
            String s=it.next();
            System.out.println(s);
        }
    }
}
