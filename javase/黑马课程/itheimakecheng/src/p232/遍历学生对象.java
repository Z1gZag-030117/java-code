package p232;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 遍历学生对象 {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<Student>();
        Student s1=new Student("zhuzhe",19);
        Student s2=new Student("11zhuzhe",13);
        Student s3=new Student("22zhuzhe",14);

        list.add(s1);
        list.add(s2);
        list.add(s3);

        //迭代器
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student s=it.next();
            System.out.println(s.getAge()+","+s.getName());
        }
        System.out.println("________________");
        //普通for
        for(int i=0;i<list.size();i++){
            Student student = list.get(i);
            System.out.println(student.getAge()+","+student.getName());
        }

        System.out.println("_____________________");
        //增强for
        for(Student stu:list){

            System.out.println(stu.getAge()+","+stu.getName());
        }

    }
}
