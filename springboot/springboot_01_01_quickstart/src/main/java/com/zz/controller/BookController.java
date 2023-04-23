package com.zz.controller;

import com.zz.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱喆
 * @version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {

    //读取yaml数据的单一数据
    @Value("${country}")
    private String country;

    @Value("${users.name}")
    private String name;

    @Value("${hobbies[1]}")
    private String hobbies;

    @Value("${tempDir}")
    private String tempDir;

    //使用自动装装装配将所有的数据分到一个对象Environment中
    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource dataSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        System.out.println(country);
        System.out.println(name);
        System.out.println(hobbies);
        System.out.println(tempDir);
        System.out.println(environment.getProperty("country"));
        System.out.println(environment.getProperty("users.name"));
        System.out.println("MyDataSource===>"+dataSource);
        return "springboot is running";
    }

}
