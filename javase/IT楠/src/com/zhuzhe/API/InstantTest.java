package com.zhuzhe.API;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class InstantTest {

    public static void main(String[] args) {

        Instant now = Instant.now();
        long l = now.toEpochMilli();
        Instant newInstant = now.plus(Duration.ofDays(365));

        System.out.println(newInstant);
        System.out.println(l);
        System.out.println("now.atZone(ZoneId.of(\"GMT:+8:00\")) = " + now.atZone(ZoneId.of("GMT+08:00")));
        System.out.println(now);

    }

}
