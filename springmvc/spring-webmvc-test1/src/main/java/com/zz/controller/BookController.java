package com.zz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 朱喆
 * @version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/show")
    @ResponseBody
    public String show() {
        System.out.println("book show running...");
        return "{'module':'springmvc'}";
    }
}
