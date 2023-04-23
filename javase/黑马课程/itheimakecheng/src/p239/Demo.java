package p239;

public class Demo {
    public static void main(String[] args) {

        Student s1=new Student("zz",20);
        Student s2=new Student("sn",21);

        System.out.println(s1.hashCode());
        System.out.println(s1.hashCode());
        System.out.println("--------");
        System.out.println(s2.hashCode());
        System.out.println("-------");
        System.out.println("zhuzhe".hashCode());
        System.out.println("shinuo".hashCode());
        System.out.println("_________");
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());


    }
}
