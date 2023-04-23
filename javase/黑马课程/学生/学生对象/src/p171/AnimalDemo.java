package p171;

public class AnimalDemo {
    public static void main(String[] args) {
        //创建动物操作类的对象，调用方法
        AnimalOperator ao = new AnimalOperator();
        Cat c = new Cat();
        ao.UseAnimlae(c);//需要Cat类型的变量，所以上一步创建Cat类型的变量
    }
}
