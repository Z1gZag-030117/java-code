package p187;

public class CatDemo {
    public static void main(String[] args) {
        CatOperator co=new CatOperator();
        Cat c=new Cat();
        co.usecat(c);

        Cat c2= co.getCat();//co.getCat返回的是c
        //现在c2==c
        c2.eat();
    }
}
