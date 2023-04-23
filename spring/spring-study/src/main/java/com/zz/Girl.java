package com.zz;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Girl {

    private String name;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("调用有参构造方法2");
    }

    public Girl() {
        System.out.println("调用无参构造方法");
    }

    public Girl(String name) {
        this.name = name;
        System.out.println("调用有参构造方法1");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
