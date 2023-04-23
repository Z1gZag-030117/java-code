package com.zhuzhe.API;

import java.time.Instant;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Instant now = Instant.now();
        Date from = Date.from(now);
        System.out.println(from);


    }

}
