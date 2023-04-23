import com.ydl.entity.User;
import com.ydl.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
@Slf4j
public class TestMybatis {
    SqlSessionFactory sqlSessionFactory=null;

    //public static final Logger logger= LoggerFactory.getLogger(TestMybatis.class);

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSqlSession() throws IOException {
        //System.out.println(sqlSessionFactory);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Object> objects = session.selectList("user.select");
            log.debug("result id [{}]",objects);
        }
    }

    @Test
    public void testMapper(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectAllUsers();
            log.debug("user if [{}]",users);
        }
    }

    @Test
    public void testSelectById(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectById(1);
            log.debug("user is [{}]",user);
        }
    }


}
