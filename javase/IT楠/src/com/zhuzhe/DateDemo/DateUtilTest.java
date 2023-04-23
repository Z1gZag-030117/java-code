package com.zhuzhe.DateDemo;

import java.text.ParseException;
import java.util.Date;

public class DateUtilTest {
    public static void main(String[] args) throws ParseException {
        Date date=new Date();
        String s = DateUtil.dateToString(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(s);

        String s1="2003-01-17 12.12.12";
        Date date1 = DateUtil.stringToDate(s1, "yyyy-MM-dd HH.mm.ss");
        System.out.println(date1);


    }
}
