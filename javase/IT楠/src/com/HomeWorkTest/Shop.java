package com.HomeWorkTest;

import java.util.Scanner;

public class Shop {
    public static String PATH="F:\\java\\testb\\test.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("选择功能：1.插入新的商品 2.删除商品 3.修改商品 4.查找商品 5.查找指定商品 6.退出");
            int function = scanner.nextInt();
            switch (function) {
                case 1:
                    Function.insert();
                    break;
                case 2:
                    Function.delete();
                    break;
                case 3:
                    Function.update();
                    break;
                case 4:
                    Function.showAll();
                    break;
                case 5:
                    Function.showOne();
                    break;
                case 6:

                    break;
            }
        }
    }
}
