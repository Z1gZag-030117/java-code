package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;


/**
 * @author 朱喆
 * @version 1.0
 */
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level loglevel(){
        return Logger.Level.BASIC;
    }

}


