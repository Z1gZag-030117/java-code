package p398;

public class Student {
    private String name;
    int age;
    public String address;

    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

     Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private void function (){
        System.out.println("function");
    }

    public void menthod1(){
        System.out.println("menthod1");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
