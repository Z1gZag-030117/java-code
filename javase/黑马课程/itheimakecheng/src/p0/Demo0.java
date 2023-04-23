package p0;

import java.util.Scanner;

public class Demo0 {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int a=sc.nextInt();
//        System.out.println(a);

//            Scanner sc=new Scanner(System.in);
//            String a=sc.next();
//        System.out.println(a);

        //一、声明并赋值
        int[] arr={1,2,3,4};//注意这里的花括号不是语句块，而且而且花括号后的分号也不能省，…不是元素意思是可以指定多个元素
        for(int i:arr){
            System.out.println(i);
        }
        System.out.println("-----------");

        //二、声明数组名开辟空间并且赋值
        int[] arr1;
        arr1=new int[]{1,2,3,4};
        for(int i:arr){
            System.out.println(i);
        }
        System.out.println("-----------");

        //三、声明数组时指定元素个数然后赋值
        int[] arr2=new int[3];
        for(int i=0;i<3;i++){
            arr2[i]=i;
        }
        for(int i: arr2){
            System.out.println(i);
        }





    }
}
