package com.zz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 朱喆
 * @version 1.0
 */
@Configuration
@ComponentScan("com.zz")    //<context:component-scan base-package="com.zz"/>
@EnableAspectJAutoProxy     //<aop:aspectj-autoproxy/>
public class SpringConfig {
}
