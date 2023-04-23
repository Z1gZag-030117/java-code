package itheima;

public class Student_test {
    public static void main(String[] args) {
        Student s = new Student();
        s.show();

        // public Student(int age)
        Student s1=new Student(20);
        s1.show();

        //public Student(String name)
        Student s2=new Student("zhuzhe");
        s2.show();

        // public Student(int age,String name)
        Student s3=new Student(20,"zhuzhe");
        s3.show();
    }
}
