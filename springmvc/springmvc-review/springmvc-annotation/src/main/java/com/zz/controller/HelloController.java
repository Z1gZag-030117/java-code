package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 朱喆
 * @version 1.0
 */
//@RequestMapping("/hello")
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        System.out.println("hello");
        model.addAttribute("msg","Hello,SpringMVCAnnotation");
        return "hello";
    }

}


