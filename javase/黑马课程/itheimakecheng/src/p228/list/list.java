package p228.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<student> list=new ArrayList<student>();

        student s1=new student("zhuzhe",19);
        student s2=new student("zzzz",190);
        student s3=new student("zz",120);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Iterator<student> it = list.iterator();
        while(it.hasNext()){
            student s=it.next();
            System.out.println(s.getName()+","+s.getAge());
        }

        System.out.println("_______________");

        for(int i=0;i<list.size();i++){
            student s=list.get(i);
            System.out.println(s.getName()+","+s.getAge());
        }



    }
}
