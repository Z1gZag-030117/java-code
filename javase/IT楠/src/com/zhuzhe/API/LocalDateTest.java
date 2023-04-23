package com.zhuzhe.API;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int i = now.lengthOfMonth();
        int i1 = now.lengthOfYear();
        Month month = now.getMonth();
        LocalDate plus = now.plus(2, ChronoUnit.DAYS);
        System.out.println(plus);
        System.out.println(month);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(now);
    }
}
