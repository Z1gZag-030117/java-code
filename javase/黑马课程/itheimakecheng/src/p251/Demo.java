package p251;

public class Demo {
    public static void main(String[] args) {

        Generic<String> g1=new Generic<String>();
        g1.setT("sn");

        Generic<Integer> g2=new Generic<Integer>();
        g2.setT(20);

       Generic<Boolean> g3=new Generic<Boolean>();
       g3.setT(true);

        System.out.println(g1.getT());
        System.out.println(g2.getT());
        System.out.println(g3.getT());



    }
}
