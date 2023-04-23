package com.zz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author 朱喆
 * @version 1.0
 */
//创建springmvc的配置文件，加载controller对应的bean
@Configuration
//@ComponentScan({"com.zz.service","com.zz.dao"})
@ComponentScan(value = "com.zz",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)
public class SpringConfig {
}
