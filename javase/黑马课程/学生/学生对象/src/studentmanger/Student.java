package studentmanger;
//Alt Insert 根据需要选择
public class Student {

    //学号
    private String num;
    //姓名
    private String name;
    //年龄
    private String age;
    //居住地
    private String address;

    //无参构造
    public Student() {
    }

    //带参构造
    public Student(String num, String name, String age, String address) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //四个成员变量的get，set方法
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

