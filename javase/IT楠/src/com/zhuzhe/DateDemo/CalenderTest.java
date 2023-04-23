package com.zhuzhe.DateDemo;

import java.util.Calendar;

public class CalenderTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        System.out.println(year + "." + month + "." + day);


    }

}
