package itheima;

public class Student {

    private String name;
    private int age;

    public Student(){}

    public Student(int age) {
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age,String name){
        this.age=age;
        this.name=name;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
