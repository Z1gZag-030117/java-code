package p171;

public class Dog extends Animal{
//    public void eat(){
//        System.out.println("狗吃屎");
//    }


    @Override
    public void eat() {
        System.out.println("狗吃屎");//重写了Animal父类的eat方法
    }
}
