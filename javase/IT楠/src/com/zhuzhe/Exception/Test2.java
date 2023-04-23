package com.zhuzhe.Exception;

public class Test2 {
    public static void main(String[] args) {
        int result = test2();
        System.out.println(result);
    }

    public static int test2() {
        int i = 1;

        try {
            i++;
            System.out.println("try" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch" + i);
        } finally {
            i = 10;
            System.out.println("finally" + i);
        }
        return i;
    }
}
