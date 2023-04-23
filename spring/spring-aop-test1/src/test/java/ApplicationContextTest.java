import com.zz.config.SpringConfig;
import com.zz.service.UserService;
import com.zz.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ApplicationContextTest {


    @Test
    public void applicationContextTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.show1();
    }

    @Test
    public void applicationContextTest2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = context.getBean(UserService.class);
        userService.show2();
    }

    @Test
    public void applicationContextTest3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserService userService = context.getBean(UserService.class);
        userService.show2();
    }

    @Test
    public void applicationContextTest4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext4.xml");
        UserService userService = context.getBean(UserService.class);
        userService.show2();
    }

    @Test
    public void annotationTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService bean = context.getBean(UserService.class);
        bean.show1();
    }


}
