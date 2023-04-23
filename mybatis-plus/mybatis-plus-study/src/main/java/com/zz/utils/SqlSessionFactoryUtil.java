package com.zz.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @author 朱喆
 * @version 1.0
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String config = "mybatis-config.xml";
            InputStream resourceAsStream = getResourceAsStream(config);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
