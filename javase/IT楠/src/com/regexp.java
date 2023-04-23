package com;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp {
    @Test
    public void test(){
        String context="my name is zigzag come from csgo";
        String regexp=".*zigzag.*";
        Pattern pattern = Pattern.compile(regexp); //编译一个正则表达式，获得编译后的结果、
        Matcher matcher = pattern.matcher(context);
        System.out.println(matcher.matches());
    }
}
