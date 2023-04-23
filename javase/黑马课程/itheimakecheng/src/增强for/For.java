package 增强for;

import java.util.ArrayList;
import java.util.List;

public class For {
    public static void main(String[] args) {

        int arr[]= {1,2,3,4};
        for (int i :  arr){
            System.out.println(i);

        }

        System.out.println("------");
        String [] s={"hello","word","java"};
        for( String ss:s){
            System.out.println(ss);
        }

        System.out.println("-----");

        List<String> list=new ArrayList<String>();
        list.add("hello");
        list.add("word");
        list.add("java");

        for(String sss : list ){
            System.out.println(sss);
        }

    }
}
