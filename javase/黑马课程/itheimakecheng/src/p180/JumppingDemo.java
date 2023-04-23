package p180;

public class JumppingDemo {
    public static void main(String[] args) {

        //Jumpping j=new Jumpping() ;//接口是抽象的内容，不能被实例化

        Jumpping j=new Cat();
        j.Jump();
    }
}
