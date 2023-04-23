package com.zhuzhe.StreamDemo;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void createTest(){
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        IntStream ints = new Random().ints(100);
        System.out.println(ints);

    }


}