package com.zhuzhe.DateDemo;

import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.getTime()/1000/60/60/24/356);

        long time=1000*60*60;
        Date date1=new Date(time);
        System.out.println(date1);


    }

}
