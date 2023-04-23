package duixiang_1;

public class duixiang_1 {
    public static void main(String[] args){

        //创建对象
        Phone p= new Phone();

        //成员赋值
        p.brand="小米";
        p.price=2999;

        //使用成员对象
        System.out.println(p.brand);
        System.out.println(p.price);

        //成员方法
        p.call();
        p.sendMassage();
    }
}
