package com.zhuzhe.Strategy;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {

        User user1=new User("1",1,1.1);
        User user2=new User("2",2,2.2);
        User user3=new User("3",3,3.3);
        User user4=new User("4",4,4.4);

        User[] user={user1,user2,user3,user4};
        UserSort userSort=new UserSort();
        userSort.sort(user, (User userx, User usery) -> userx.getAge()-usery.getAge());



        System.out.println(Arrays.toString(user));
    }
}
