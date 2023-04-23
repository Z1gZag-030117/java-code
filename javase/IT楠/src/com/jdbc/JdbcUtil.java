package com.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Properties properties = new Properties();
            properties.load(JdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String url = properties.getProperty("mysql.url");
            String user = properties.getProperty("mysql.user");
            String password = properties.getProperty("mysql.password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
