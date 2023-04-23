package com.zhuzhe.homework;

public class Test {
    public static void main(String[] args) {

        Student student=new Student(1,"zhuzhe");
        Student student1=new Student(1,"zhuzhe");
        Student student2=new Student(2,"sn");

        System.out.println(student.equals(student1));
        System.out.println(student.equals(student2));

        System.out.println(student.toString());

    }
}
