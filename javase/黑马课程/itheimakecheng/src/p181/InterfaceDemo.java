package p181;

public class InterfaceDemo {
    public static void main(String[] args) {
        Inter i = new Interimpl();
//        i.num=20;
        System.out.println(i.num);
        System.out.println(i.num2);
        System.out.println(Inter.num); //可通过inter直接输出num的值
    }
}
