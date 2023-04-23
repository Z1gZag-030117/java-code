package com.IO;

import org.junit.Test;

import java.util.Scanner;

public class test {


    public static int isPrime(int num){
        int flag=0;
        for (int i = 2; i*i <=num; i++) {
            if(num%i==0){
                flag++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int t;
        Scanner scanner=new Scanner(System.in);
        for (t=scanner.nextInt();t>0;t--){
            int num,flag;
            Scanner scanner2=new Scanner(System.in);
            num=scanner2.nextInt();
            flag=isPrime(num);
            if (flag!=0){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
