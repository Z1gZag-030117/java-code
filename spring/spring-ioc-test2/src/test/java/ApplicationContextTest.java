import com.zz.config.SpringConfig;
import com.zz.dao.UserDao;
import com.zz.dao.impl.UserDaoImpl;
import com.zz.service.UserService;
import com.zz.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import javax.swing.*;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ApplicationContextTest {

    @Test
    public void test(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = context.getBean(UserDaoImpl.class);
//        UserService userService = context.getBean(UserServiceImpl.class);
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        System.out.println(userService);
//        System.out.println(userDao);
//        userDao.show();
//        userService.show();
//        System.out.println(dataSource);
//        context.close();

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userDao = context.getBean("userDao");
        System.out.println(userDao);
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService bean = context.getBean(UserService.class);
        bean.show();
    }

}
