package com.Collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {

    public static void main(String[] args) {
        TreeSet<User> treeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {

                int i = u1.getAge() - u2.getAge();
                int j = i == 0 ? u1.getName().compareTo(u2.getName()) : i;
                return j;
            }
        });
        User user = new User("zz", 70);
        User user1 = new User("az", 20);
        User user2 = new User("bz", 40);
        User user3 = new User("zz", 30);
        User user4 = new User("zzy", 30);

        treeSet.add(user);
        treeSet.add(user1);
        treeSet.add(user2);
        treeSet.add(user3);
        treeSet.add(user4);
    }

}
