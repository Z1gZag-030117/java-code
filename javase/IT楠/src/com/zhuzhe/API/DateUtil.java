package com.zhuzhe.API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_PATTERN="yyyy-MM-dd HH:mm:ss";

    public static Date now(){
        return new Date();
    }

    public static Date now(String date){
        return now(date,DateUtil.DEFAULT_PATTERN);
    }

    public static Date now(String date,String pattern){
        Date parse=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        try {
            parse = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public static String nowString(String pattern){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(date);
    }

    public static String nowString(){
        return nowString(DateUtil.DEFAULT_PATTERN);
    }
}
