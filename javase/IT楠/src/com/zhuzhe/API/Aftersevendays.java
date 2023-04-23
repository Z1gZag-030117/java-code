package com.zhuzhe.API;

import java.util.Date;

public class Aftersevendays {

    public static void main(String[] args) {

        Date date = new Date();

        long time = date.getTime();

        time = time + 7 * 24 * 60 * 60 * 1000;

        System.out.println(new Date(time));

    }

}
