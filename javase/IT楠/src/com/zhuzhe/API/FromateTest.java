package com.zhuzhe.API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FromateTest {
    public static void main(String[] args) throws ParseException {
        Date now = DateUtil.now();
        Date now1 = DateUtil.now("2003-11-11 11:11:11");
        System.out.println(now);
        System.out.println(now1);

        System.out.println("DateUtil.nowString() = " + DateUtil.nowString());
        System.out.println("DateUtil.nowString(\"yyyy.MM.dd. '_' HH:mm:ss\") = " + DateUtil.nowString("yyyy.MM.dd. '_' HH:mm:ss"));
    }


}
