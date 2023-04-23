package p247;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<student> tr = new TreeSet<student>(new Comparator<student>() {
            @Override
            public int compare(student s1, student s2) {
                int num = s1.getAge() - s2.getAge();
                int num1 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num1;
            }
        });

        student s1=new student("zhuzhe",20);
        student s2=new student("zhuzhe",20);
        student s3=new student("sn",19);
        student s4=new student("ssnn",19);

        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);

        for (student s:tr){
            System.out.println(s.getName()+";"+s.getAge());
        }




    }
}
