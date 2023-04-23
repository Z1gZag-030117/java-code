package com.zhuzhe.Exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        while (true){
            int num1=10;
            Scanner scanner=new Scanner(System.in);
            int num2=scanner.nextInt();

            try {
                int res=num1/num2;
                System.out.println(res);
            }catch (Exception e){
                System.out.println("!=0");
            }


            System.out.println("后面");
        }

    }
}
