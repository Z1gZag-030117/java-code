package p246;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<student> tr=new TreeSet<student>();

        student s1=new student("zhuzhe",19);
        student s2=new student("sn",100);
        student s3=new student("ssnn",12);
        student s4=new student("zz",17);
        student s5=new student("zz",18);
        student s6=new student("snzz",18);



        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);
        tr.add(s5);
        tr.add(s6);


        for(student s:tr){
            System.out.println(s.getName()+";"+s.getAge());
        }




    }




}
