package pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

import static pool.BaseDao.DATASOURCE;

public class PoolTest {

    @Test
    public void test1() throws Exception{
        Properties properties=new Properties();
        properties.load(PoolTest.class.getClassLoader().getResourceAsStream("pool/druid.properties"));

        DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.configFromPropety(properties);
        
        System.out.println(druidDataSource.getCreateCount());
    }

    @Test
    public void test2() throws Exception{
        Properties properties=new Properties();
        properties.load(PoolTest.class.getClassLoader().getResourceAsStream("pool/druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);

        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test3() throws Exception{
        Properties properties=new Properties();
        properties.load(PoolTest.class.getClassLoader().getResourceAsStream("pool/druid.properties"));

        DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.configFromPropety(properties);

        Connection connection = druidDataSource.getConnection();
        System.out.println(druidDataSource.getCreateCount());
    }

    @Test
    public void test4() throws Exception{
        Properties properties=new Properties();
        properties.load(PoolTest.class.getClassLoader().getResourceAsStream("pool/hikari.properties"));

        HikariConfig hikariConfig=new HikariConfig(properties);
        DataSource dataSource=new HikariDataSource(hikariConfig);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void test5() throws  Exception{
        System.out.println(DATASOURCE.getConnection());
    }
}
