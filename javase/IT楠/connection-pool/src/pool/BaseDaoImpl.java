package pool;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class BaseDaoImpl<T> implements BetterBaseDao<T> {
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

    public void ConnectionClose(Connection conn, Statement stat, ResultSet res) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int sava(T t) {
        Object object = (Object) t;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class<?> aClass = t.getClass();
            String tName = aClass.getName().substring(aClass.getName().lastIndexOf("." + 1)).toLowerCase();
            Field[] fields = aClass.getDeclaredFields();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into").append(tName).append("values(");
            for (int i = 0; i < fields.length; i++) {
                sql.append("?,");
            }
            sql.append(")");
            String finalSql = sql.toString().replace(",)", ")");
            System.out.println(finalSql);
            //String sql="insert into "+tName.toLowerCase(Locale.ROOT)+" values(?,?,?)";
            connection = DATASOURCE.getConnection();
            statement = connection.prepareStatement(finalSql);
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].getType() == int.class) {
                    statement.setInt(i, fields[i].getInt(object));
                } else if (fields[i].getType() == String.class) {
                    statement.setString(i, fields[i].get(object).toString());
                }
            }
            return statement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<T> selectAll(Class clazz) {
        Connection connection=null;
        PreparedStatement statement=null;
        List<T> objs=new ArrayList<>();
        try {
            //1.定义sql
            String tName = clazz.getName().substring(clazz.getName().lastIndexOf("." + 1)).toLowerCase();
            Field[] fields = clazz.getDeclaredFields();
            StringBuilder sql = new StringBuilder();
            sql.append("select * from ").append(tName);
            //2。获取链接
            connection = DATASOURCE.getConnection();
            statement=connection.prepareStatement(sql.toString());

            //3.执行
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Object object=clazz.newInstance();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    if (fields[i].getType()==int.class){
                        fields[i].setInt((T)object,resultSet.getInt(fields[i].getName()));
                    }else if (fields[i].getType()==String.class){
                        fields[i].set((T)object,resultSet.getString(fields[i].getName()));
                    }
                }
                objs.add((T)object);
            }


        }catch (SQLException |IllegalAccessException|InstantiationException e){
            e.printStackTrace();
        }
        return objs;
    }

    @Override
    public T selectOne(int id) {
        return null;
    }

    @Override
    public int update(T t) {
        return 0;
    }
}
