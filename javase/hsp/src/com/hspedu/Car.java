package com.hspedu;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Car {
    public String brand = "奥迪";
    public int price = 100000;
    public String color = "白";
    private String name = "z";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
