import com.zz.dao.UserDao;
import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public class BeanTest {

    @Test
    public void singletonTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object user = context.getBean("user");
        Object user1 = context.getBean("user");
        System.out.println(user==user1);
    }

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean(User.class);
        user.getCat().shout();
        user.getDog().shout();
        System.out.println(user.toString());
    }

    @Test
    public void LogTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService =  context.getBean(UserService.class);
        userService.add();
    }

    @Test
    public void diyLogTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService =  context.getBean(UserService.class);
        userService.delete();
    }

    @Test
    public void annotationTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService =  context.getBean(UserService.class);
        userService.delete();
    }

    @Test
    public void selectAll() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }

}
