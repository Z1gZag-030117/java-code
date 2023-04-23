import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ApplicationTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        System.out.println("userService.show() = " + userService.show());
    }

}
