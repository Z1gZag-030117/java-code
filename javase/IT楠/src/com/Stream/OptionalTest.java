package com.Stream;



import com.Collection.User;

import java.util.Optional;
import java.util.Scanner;

public class OptionalTest {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int i= scanner.nextInt();
        User user=new User("zz",10);
        if (i==0){
            user=null;
        }
        Optional<User> optional=Optional.ofNullable(user);
//        User user1 = optional.orElse(new User("m", 0));
//        System.out.println(user1);
        //optional.ifPresent(System.out::println);//传入一个消费者

        User user1 = optional.orElseGet(() -> {
            return new User("sn", 1);
        });

        System.out.println("user1 = " + user1);


    }

}
