package com.zz.beans;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author 朱喆
 * @version 1.0
 */
@Component
public class OtherBean {

    @Bean("dataSource")
    public DataSource dataSource(@Value("${jdbc.Driver}") String driverClassName){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        return  dataSource;
    }

}
