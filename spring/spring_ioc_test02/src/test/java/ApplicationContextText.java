import com.itheima.beans.OtherBean2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 朱喆
 * @version 1.0
 */
public class ApplicationContextText {

    @Test
    public void applicationContextTest(){
        //System.setProperty("spring.profiles.active","test");

        //xml方式的Spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //注解方式去加载Spring的核心配置类
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        /*UserService userService = applicationContext.getBean(UserService.class);
        userService.show();*/
        /*Object userDao = applicationContext.getBean("userDao2");
        System.out.println(userDao);*/
//        UserService userService = applicationContext.getBean(UserService.class);
//        userService.show();
        OtherBean2 bean = applicationContext.getBean(OtherBean2.class);
        System.out.println(bean);

    }

}
