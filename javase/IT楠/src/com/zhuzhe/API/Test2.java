package com.zhuzhe.API;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        Instant now=Instant.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("GMT+08:00"));
        System.out.println(zonedDateTime);

        LocalDate now1 = LocalDate.now();
        System.out.println(now1);

        Date date=new Date();
        System.out.println(date.getTime());
    }

}
