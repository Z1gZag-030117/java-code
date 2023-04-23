package p191;

public class Outer {
    private int num=10;
    public void method(){
        class Inner{
            public void show(){
                System.out.println(num);//局部内部类外界无法直接访问，要通过外部类简介访问
            }
        }
        Inner i=new Inner();
        i.show();

    }
}
