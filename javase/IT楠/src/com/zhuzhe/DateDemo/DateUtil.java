package com.zhuzhe.DateDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private DateUtil(){}

    public static String dateToString(Date date,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        String s = simpleDateFormat.format(date);
        return s;
    }

    public static Date stringToDate(String str,String format) throws ParseException {

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Date date = simpleDateFormat.parse(str);
        return date;
    }


}
