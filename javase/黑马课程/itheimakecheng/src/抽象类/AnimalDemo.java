package 抽象类;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal a=new Cat();
        a.setAge(18);
        a.setName("jiafei");
        System.out.println(a.getAge()+","+a.getName());
        a.eat();

        Animal a1=new Dog();
        a1.setName("zhuzhe");
        a1.setAge(15);
        System.out.println(a1.getAge()+","+a1.getName());
        a1.eat();
    }
}
