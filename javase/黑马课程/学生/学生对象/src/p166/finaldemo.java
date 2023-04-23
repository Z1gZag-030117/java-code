package p166;

public class finaldemo {
    public static void main(String[] args) {

        //final修饰基本类型变量,值不能变
        final int age =20;
        System.out.println(age);


        //final修饰引用类型变量，地址值不能变
        final student s=new student();
        s.age=100;
        System.out.println(s.age);


    }



}
