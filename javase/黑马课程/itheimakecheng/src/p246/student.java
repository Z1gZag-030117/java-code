package p246;

public class student implements Comparable<student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public student() {
    }

    @Override//重写Comparable方法
    public int compareTo(student s) {
        int num = this.age - s.age;//年龄从大到小排序
        int num1 = num == 0 ? this.name.compareTo(s.name) : num;//num=0时，年龄相同，比较两个人的姓名
        return  num1;

    }
}
