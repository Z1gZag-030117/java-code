package com.zhuzhe.DateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) throws ParseException {

        //date->String
        Date date=new Date();
        //SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        //String->date
        String s="2022-5-8 14:33:01";
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat1.parse(s);
        System.out.println(parse);


    }

}
