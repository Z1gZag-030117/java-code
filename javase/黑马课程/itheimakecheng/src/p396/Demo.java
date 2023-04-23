package p396;

public class Demo {
    public static void main(String[] args) {
        ClassLoader c=ClassLoader.getSystemClassLoader();
        System.out.println(c);

        ClassLoader c1=c.getParent();
        System.out.println(c1);

        ClassLoader c2=c1.getParent();
        System.out.println(c2);
        }
    }

