package p182;

public class AnimalDemo {
    public static void main(String[] args) {
        //创建对象，调用方法
        //接口
        Jumpping j=new Dog();
        j.jump();


        System.out.println("--------------");


        //无参构造方法
        Animal a=new Dog();
        a.setName("huang");
        a.setAge(5);
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
        ((Dog)a).jump();//编译看左边，左边Animal内没有jump方法，将a强转成Dog，调用Dog内执行接口内的jump


    }
}
