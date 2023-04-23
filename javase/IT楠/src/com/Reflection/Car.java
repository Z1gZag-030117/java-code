package com.Reflection;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Car {

    public String brand="BMW";
    public int price=1000000;
    public String color="black";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
