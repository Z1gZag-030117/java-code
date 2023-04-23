package com.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 朱喆
 * @version 1.0
 */
public class druid_test {

    public static void main(String[] args) throws Exception {

        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        List<animal> list= null;
        try {
            connection.setAutoCommit(false);
            list = new ArrayList<>();
            String sql="select * from animal where nice=1";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                animal animal = new animal();
                animal.setName(resultSet.getString("animalname"));
                animal.setID(resultSet.getInt("ID"));
                animal.setNice(resultSet.getInt("nice"));
                list.add(animal);
            }
        } catch (Exception throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }

        System.out.println(list);
        //System.out.println(connection);
        connection.close();
    }

}
