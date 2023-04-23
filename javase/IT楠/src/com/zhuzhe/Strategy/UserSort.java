package com.zhuzhe.Strategy;

public class UserSort {

    public void sort(User[] user,Comparator comparator){
        for (int i = 0,j=0; j < user.length-1-i; j++) {
            if(comparator.compare(user[j],user[j+1])>0){
                User temp=user[j];
                user[j]=user[j+1];
                user[j+1]=temp;
            }
        }
    }


}
