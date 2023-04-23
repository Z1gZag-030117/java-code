import com.zz.config.SpringConfig;
import com.zz.controller.UserController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 朱喆
 * @version 1.0
 */
public class test {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context.getBean(UserController.class));
    }



}
