package com.jdbc;

import com.mysql.cj.jdbc.ClientPreparedStatement;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcTest {
    @Test
    public void test1() throws Exception {

        //1.数据库连接的4个基本要素：
        String url = "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        //8.0之后名字改了  com.mysql.cj.jdbc.Driver
        String driverName = "com.mysql.cj.jdbc.Driver";
        //2.实例化Driver
        Class clazz = Class.forName(driverName);
        Driver driver = (Driver) clazz.newInstance();
        //3.注册驱动
        DriverManager.registerDriver(driver);
        //4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        Statement statement = conn.createStatement();

    }

    @Test
    public void test2() throws Exception {
        //1.数据库连接的4个基本要素：
        String url = "jdbc:mysql://localhost:3306/mydata?serverTimezone=UTC&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        //8.0之后名字改了  com.mysql.cj.jdbc.Driver
        String driverName = "com.mysql.cj.jdbc.Driver";
        //2.实例化Driver
        //3.注册驱动
        //4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void test3() throws Exception {
        Properties properties = new Properties();
        properties.load(JdbcTest.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        String url = properties.getProperty("mysql.url");
        String user = properties.getProperty("mysql.user");
        String password = properties.getProperty("mysql.password");
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void TestStatement1() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            statement.execute("insert into notice values (4,4,4)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Test
    public void TestStatement2() {
        String sql = "select * from notice";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<notice> notices = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                int userID = resultSet.getInt("userID");
                String content = resultSet.getString("content");
                notices.add(new notice(ID, userID, content));
            }
            System.out.println(notices);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }
    }

    @Test
    public void TestStatement3() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from notice where ID > ?";
            connection = JdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("ID"));
                System.out.println(resultSet.getInt("userID"));
                System.out.println(resultSet.getString("content"));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeAll(connection, statement, resultSet);
        }
    }

    @Test
    public void TestStatement4() {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            connection.setAutoCommit(false);
            String sql = "update notice set userID=? ,content=? where ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,9);
            preparedStatement.setString(2,"test3");
            preparedStatement.setInt(3,1);
            int i=preparedStatement.executeUpdate();
            System.out.println(i);

            int j=2/0;

            String sql2 = "update notice set userID=? ,content=? where ID=?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1,10);
            preparedStatement.setString(2,"test4");
            preparedStatement.setInt(3,2);
            int i2=preparedStatement.executeUpdate();
            System.out.println(i2);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JdbcUtil.closeAll(connection,preparedStatement, resultSet);
        }
    }

    @Test
    public void test5() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mydata";
        String user="root";
        String psw="123456";
        Connection connection = DriverManager.getConnection(url, user, psw);
        String sql1=" update animal set nice = 1 where ID > 20";
        String sql2=" update animal set nice = 2 where ID < 20";
        Statement statement = connection.createStatement();
        try {
            //开启事务
            connection.setAutoCommit(false);

            int i = statement.executeUpdate(sql1);
            System.out.println(i);
            int i1 = statement.executeUpdate(sql2);
            System.out.println(i1);

            //提交事务
            connection.commit();
        } catch (Exception throwables) {
            //出现异常，事务回滚
            connection.rollback();

            throwables.printStackTrace();
        }
        statement.close();
        connection.close();


    }

    @Test
    public void test6() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/mydata";
        String user="root";
        String psw="123456";
        Connection connection = DriverManager.getConnection(url, user, psw);
        String sql1="select * from animal";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql1);
        List<animal> list=new ArrayList<>();
        while(resultSet.next()){
            animal animal=new animal();
            animal.setID(resultSet.getInt("ID"));
            animal.setPark(resultSet.getString("park"));
            animal.setName(resultSet.getString("animalname"));
            animal.setVariety(resultSet.getString("variety"));
            animal.setNice(resultSet.getInt("nice"));

            list.add(animal);
        }

        System.out.println(list);

        resultSet.close();
        statement.close();
        connection.close();
    }


}
