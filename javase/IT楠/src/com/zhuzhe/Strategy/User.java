package com.zhuzhe.Strategy;

public class User  {

    public User() {
    }

    public User(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    private String name;
    private Integer age;
    private Double height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }


}
