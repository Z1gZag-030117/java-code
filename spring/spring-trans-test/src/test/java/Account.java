import com.zz.config.SpringConfig;
import com.zz.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 朱喆
 * @version 1.0
 */
public class Account {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = context.getBean(AccountService.class);
        bean.transferMoney("zz","sn",500);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        AccountService bean = context.getBean(AccountService.class);
        bean.transferMoney("zz","sn",500);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService bean = context.getBean(AccountService.class);
        bean.transferMoney("zz","sn",500);
    }





}
