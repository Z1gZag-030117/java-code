package com.zz.pojo;

import org.springframework.stereotype.Component;

/**
 * @author 朱喆
 * @version 1.0
 */
@Component("cat")
public class Cat {

    public void shout(){
        System.out.println("Cat");
    }

}
