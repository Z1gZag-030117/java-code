package com.Collection;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<User> treeSet=new TreeSet<>();
        User user=new User("zz",70);
        User user1=new User("az",20);
        User user2=new User("bz",40);
        User user3=new User("zz",30);
        User user4=new User("zzy",30);

        treeSet.add(user);
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        treeSet.add(user4);

        for(User u:treeSet){
            System.out.println(u.getName()+","+u.getAge());
        }

    }

}
