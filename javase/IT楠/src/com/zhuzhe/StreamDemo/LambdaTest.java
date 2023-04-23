package com.zhuzhe.StreamDemo;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest {

    List<Person> person=new ArrayList<>();

    @Before
    public void initDate(){
        person.add(new Person("zz",1));
        person.add(new Person("sn",43));
        person.add(new Person("01",3));
        person.add(new Person("02",44));
        person.add(new Person("03",12));
        person.add(new Person("04",32));
        person.add(new Person("05",234));
        person.add(new Person("06",5436));
    }


    List<Integer> list = Arrays.asList(3, 4, 1, 42, 25, 46);

    @Test
    public void find() {
        Optional<Integer> first = list.stream().findFirst();
        Optional<Integer> any = list.stream().findAny();
        first.ifPresent(System.out::println);
        any.ifPresent(System.out::println);

        Optional<Integer> first1 = list.parallelStream().findFirst();
        Optional<Integer> any1 = list.parallelStream().findAny();
        first1.ifPresent(System.out::println);
        any1.ifPresent(System.out::println);
    }

    @Test
    public void MatchTest() {
        boolean b = list.stream().allMatch(l -> l > 20);
        System.out.println("b = " + b);
        boolean b1 = list.stream().anyMatch(l -> l > 20);
        System.out.println("b1 = " + b1);
    }

    @Test
    public void CountTest() {
        long count = list.stream().count();
        System.out.println(count);
    }

    @Test
    public void AverageTest() {
        OptionalDouble average = list.stream().mapToInt(p -> p).average();
        average.ifPresent(System.out::println);
    }

    @Test
    public void MaxTest() {
        OptionalInt max = new Random().ints(20).max();
        max.ifPresent(value -> System.out.println("value = " + value));
    }

    @Test
    public void reduceTest() {
        int reduce = IntStream.of(1, 2, 3, 45).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void joiningTest(){
        List<String> list=Arrays.asList("1","2","4");
        String collect = list.stream().collect(Collectors.joining("."));
        System.out.println("collect = " + collect);
    }

    @Test
    public void filterTest(){
        person.stream().filter(p->p.getAge()>20).forEach(System.out::println);
    }

    @Test
    public void collectTest(){
        List<Person> collect = person.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }


    @Test
    public void mapTest(){
        List<String> collect = person.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);


        person.stream().map(person1 -> {
            person1.setAge(person1.getAge()+100);
            return person1;
        }).forEach(System.out::println);
    }

    @Test
    public void sortTest(){
        person.stream().sorted((p1,p2)-> p1.getAge()- p2.getAge()).forEach(System.out::println);
    }

    @Test
    public void otherTest(){
        person.stream().sorted(Comparator.comparingInt(Person::getAge)).limit(3).forEach(System.out::println);


        IntStream.of(1,2,5,4,2,5,4,8,2,2,2,5).distinct().skip(2).forEach(System.out::println);
    }


}
