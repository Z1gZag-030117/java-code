package p171;

public class AnimalDemo {
    public static void main(String[] args) {
//        AnimalOperator ao=new AnimalOperator();
//
//        Cat c=new Cat();
//
//        ao.useAnimla(c);
//
//        Dog d=new Dog();
//        ao.useAnimal(d);

        AnimalOperator ao=new AnimalOperator();//创建动物操作对象

        Cat c=new Cat();//创建猫的对象
        ao.useAnimal(c);

        Dog d=new Dog();
        ao.useAnimal(d);



    }
}
