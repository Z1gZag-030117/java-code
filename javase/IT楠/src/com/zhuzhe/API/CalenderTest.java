package com.zhuzhe.API;

import java.util.Calendar;

public class CalenderTest {



    public static void main(String[] args) {

        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        month++;
        int day=calendar.get(Calendar.DATE);

        System.out.println(year+"年"+month+"月"+day+"日");

    }



}
