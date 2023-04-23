package p225;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class collection {
    public static void main(String[] args) {
        Collection<student> c=new ArrayList<student>();

        student s1=new student("朱喆",19);
        student s2=new student("吕程阳",20);
        student s3=new student("sn",18);

        c.add(s1);
        c.add(s2);
        c.add(s3);

        Iterator<student> it = c.iterator();

        while(it.hasNext()){
            student s = it.next();
            System.out.println(s.getAge()+","+s.getName());



        }

    }
}
