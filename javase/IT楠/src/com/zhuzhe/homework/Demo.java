package com.zhuzhe.homework;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String 专业;
        String 方向;
        System.out.println("是否是学霸?");
        String 成绩 = scanner.next();
        boolean 考研;
        专业 = 成绩.equals("是") ? "计算机科学" : "软件工程";
        if (专业.equals("计算机科学")) {
            System.out.println("专业:"+专业);
            System.out.println("考研 = " + true);
        } else {
            System.out.println("专业:"+专业);
            System.out.println("学什么?(java/python)");
            方向 = scanner.next();
            考研 = !方向.equals("java");
            System.out.println("考研 = " + 考研);
        }
    }
}
