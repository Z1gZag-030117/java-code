package com.zz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zz.beans.OtherBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import com.zz.mapper.*;

/**
 * @author 朱喆
 * @version 1.0
 */
@Configuration //标注这个类是一个配置类(代替配置文件)+@Component
//<context:component-scan base-package="com.zz"/>
@ComponentScan("com.zz")
//<context:property-placeholder location="classpath:jdbc.properties"/>
@PropertySource( "classpath:jdbc.properties")
@Import(OtherBean.class)
//Mapper的接口扫描
@MapperScan("com/zz/mapper")
public class SpringConfig {

    @Bean
    public DataSource dataSource(
            @Value("${jdbc.driver}") String driverClassName,
            @Value("${jdbc.url}") String url,
            @Value("${jdbc.user}") String username,
            @Value("${jdbc.password}") String password
    ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }



}
