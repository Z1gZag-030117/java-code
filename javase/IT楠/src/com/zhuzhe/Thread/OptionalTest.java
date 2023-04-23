package com.zhuzhe.Thread;

import java.util.Optional;
import java.util.Scanner;

public class OptionalTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        User user = new User();
        user.setName("zz");
        user.setAge(1);

        if (i == 0) {
            user = null;
        }

        Optional<User> optional = Optional.ofNullable(user);
//        User user1 = optional.orElse(new User("xx", 12));
//        System.out.println(user1.getName()+user1.getAge());
//        optional.ifPresent(System.out::println);
        User user1 = optional.orElseGet(User::new);
        System.out.println(user1);

    }

}
