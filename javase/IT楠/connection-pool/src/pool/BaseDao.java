package pool;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BaseDao {

    public static DataSource DATASOURCE = null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(PoolTest.class.getClassLoader().getResourceAsStream("pool/druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DATASOURCE = new DruidDataSource();
        ((DruidDataSource) DATASOURCE).configFromPropety(properties);
    }

    public void ConnectionClose(Connection conn, Statement stat, ResultSet res){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
