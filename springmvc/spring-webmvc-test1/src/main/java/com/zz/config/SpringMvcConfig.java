package com.zz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 朱喆
 * @version 1.0
 */
//创建springmvc的配置文件，加载controller对应的bean
@Configuration
@ComponentScan("com.zz.controller")
@EnableWebMvc
public class SpringMvcConfig {
}
