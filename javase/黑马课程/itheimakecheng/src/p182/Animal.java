package p182;

public class Animal {
    private int age;
    private String name;

    public Animal() {
    }//无参构造方法

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }//带参构造方法

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){

    }//成员方法
}
