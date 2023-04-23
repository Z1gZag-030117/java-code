package p243;

import java.util.HashSet;

public class HashDemo {
    public static void main(String[] args) {
        HashSet<Student> has=new HashSet<Student>();

        Student s1=new Student("zhuzhe",1);
        Student s2=new Student("zz",14);
        Student s3=new Student("sn",12);

        has.add(s1);
        has.add(s2);
        has.add(s3);

        for (Student s:has){
            Student ss=s;
            System.out.println(ss.getName()+","+ss.getAge());
        }


    }
}
