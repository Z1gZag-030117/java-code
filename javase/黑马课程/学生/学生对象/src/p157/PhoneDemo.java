package p157;

public class PhoneDemo {
    public static void main(String[] args) {
        //创建对象，调用方法
        Phone p=new Phone();
        p.call("朱喆");
        System.out.println("--------");

        NewPhone np=new NewPhone();
        np.call("zhuzhe");//继承了Phone，可以使用Phone内的方法

    }
}
