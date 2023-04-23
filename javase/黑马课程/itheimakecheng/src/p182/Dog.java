package p182;

public  class Dog extends Animal implements Jumpping{

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }//重写成员方法

    @Override
    public void jump() {
        System.out.println("狗可以调高看");

    }

    public Dog() {
    }//无参

    public Dog(int age, String name) {
        super(age, name);
    }//带参
}
