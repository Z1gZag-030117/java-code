package com.zhuzhe.homework;

/**
 * 超级数组
 */

public class SuperArray {

    private int[] elements;
    private int flag = -1;//当前存储位置

    //初始化数组，长度为10
    public SuperArray() {
        this(10);
    }

    public SuperArray(int capacity) {
        elements = new int[capacity];
    }


    public void add(int data) {
        flag++;

        if (flag > elements.length - 1) {
            int[] temp = new int[elements.length * 2];
            for (int i = 0; i < elements.length - 1; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }

        elements[flag] = data;

    }

    public void delete(int index) {
        for (int i = index + 1; i < elements.length - 1; i++) {
            elements[i - 1] = elements[i];
        }
        flag--;
    }

    public void set(int index, int newdata) {
        elements[index] = newdata;
    }

    public int select(int index) {
        return elements[index];
    }

    public int size(){
        return flag;
    }

    public String arrayToString (){
        String result="[";
        for (int i = 0; i <= flag; i++) {
            result+=elements[i]+",";
        }
        return  result.substring(0,result.length()-1)+"]";
    }
}
