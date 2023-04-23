package p249;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class random {
    public static void main(String[] args) {
        Set<Integer> s=new HashSet<Integer>();

       Random r=new Random();
        while(s.size()<10){
            int number=r.nextInt(20)+1;
            s.add(number);

        }

        for (Integer i:s){
            System.out.println(i);
        }

    }
}
