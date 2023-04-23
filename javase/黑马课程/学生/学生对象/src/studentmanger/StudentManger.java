package studentmanger;

import java.util.Scanner;

public class StudentManger {
    public static void main(String[] args) {
        System.out.println("————————欢迎来到学生管理系统————————");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看所有学生");
        System.out.println("5.退出");

        //输入
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();

        switch (line){
            case "1":
                System.out.println("添加学生");
                break;
            case "2":
                System.out.println("删除学生");
                break;
            case "3":
                System.out.println("修改学生");
                break;
            case "4":
                System.out.println("查看所有学生");
                break;
            case "5":
                System.out.println("退出");
                System.exit(0);//JVM退出
        }

    }
}
