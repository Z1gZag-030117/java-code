package 多态;

public class animal {
    public static void main(String[] args) {
        //7.创建纯纯的子类对象
        Dog2 d = new Dog2();
        System.out.println(d.sum);//20,子类自己的属性
        d.eat();//小狗爱吃肉包子,子类自己的方法

        //8.创建多态对象
        /*口诀1：父类引用指向子类对象*/
        /*口诀2：编译(保存)看左边，运行(效果)看右边*/
        Animal2 a = new Dog2();
        /*多态中，成员变量使用的是父类的*/
        System.out.println(a.sum);//10
        /*多态中，方法的声明使用的是父类的，方法体使用的是子类的*/
        a.eat();//小狗爱吃肉包子
        /*多态中，调用的静态方法是父类的，因为多态对象把自己看作是父类类型
         * 直接使用父类中的静态资源*/
        a.play();//没有提示，玩啥都行~
        Animal2.play();
    }
}
//1.创建父类
class Animal2{
    //3.创建父类的成员变量
    int sum = 10;
    //4.创建父类的普通方法
    public void eat(){
        System.out.println("吃啥都行~");
    }
    //9.1定义父类的静态方法play
    public static void play(){
        System.out.println("玩啥都行~");
    }
}
//2.创建子类
class Dog2 extends Animal2 {
    //5.定义子类的成员变量
    int sum = 20;

    //6.重写父类的方法
    @Override
    public void eat() {
        System.out.println("小狗爱吃肉包子");
    }

    //9.2创建子类的静态方法play
    //@Override
    /*这不是一个重写的方法，只是恰巧在两个类中出现了一模一样的两个静态方法
     * 静态方法属于类资源，只有一份，不存在重写的现象
     * 在哪个类里定义，就作为哪个类的资源使用*/
    public static void play() {
        System.out.println("小狗喜欢玩皮球~");
    }
}
