package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao extends BaseDao{

    public static void main(String[] args) {
        User user=new User(1,"zhuzhe",123);
        UserDao userDao=new UserDao();
        userDao.saveUser(user);
    }

    public int saveUser(User user){
        Connection connection = null;
        PreparedStatement statement=null;
        try {
            String sql="insert into user values (?,?,?)";
            connection= DATASOURCE.getConnection();
            statement=connection.prepareStatement(sql);
            statement.setInt(1,1);
            statement.setString(2,"zhuzhe");
            statement.setInt(3,123);
            int rows=statement.executeUpdate();
            return rows;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionClose(connection,statement,null);
        }
        return -1;
    }
}
