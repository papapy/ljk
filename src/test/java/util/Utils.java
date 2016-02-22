package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by XKey on 2016/1/12.
 */
public class Utils {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static ApplicationContext getContext() {
        return context;
    }
}
