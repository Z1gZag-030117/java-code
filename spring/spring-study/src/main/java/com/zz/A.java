package com.zz;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 朱喆
 * @version 1.0
 */
public class A implements BeanNameAware , ApplicationContextAware {

    private String name;
    private ApplicationContext applicationContext;

    public void setName(String name){
        this.name=name;
    }

    public void printName(){
        System.out.println("拿到容器"+applicationContext);
        System.out.println(name);
    }


    @Override
    public void setBeanName(String name) {
        this.name=name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
