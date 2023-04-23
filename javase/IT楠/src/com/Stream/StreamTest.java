package com.Stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void createTest(){

        //使用集合的方式
        List<String> list=new ArrayList<>();
        Stream<String> stream = list.stream();

        int[] arr={1,2,3,4,5};
        IntStream stream1 = Arrays.stream(arr);

        String[] strings={"1"};
        Stream<String> stream2 = Arrays.stream(strings);

        //Stream的静态方式
        Stream<String> concat = Stream.concat(stream, stream2);
        Stream<String> a = Stream.of("a", "b");


        //Random
        IntStream ints = new Random().ints(100);
        

    }

}
