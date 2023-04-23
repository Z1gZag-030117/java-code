package p398;

public class Demo {
    public static void main(String[] args) {
        //通过类的class属性来获取对应的class对象
        Class<Student> c1 = Student.class;
        System.out.println(c1);

        //调用对象的getclass方法，返回该对象所属类对应的class对象
        Student s=new Student();
        Class<? extends Student> c3 = s.getClass();
        System.out.println(c1==c3);

        //使用class类中的静态方法forname（String className ）
        Class<?> c4 = null;
        try {
            c4 = Class.forName("p398.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1==c4);

    }
}
