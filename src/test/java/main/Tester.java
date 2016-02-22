package main;

import club.ljk.admin.user.service.UserService;
import org.springframework.context.ApplicationContext;
import util.Utils;

/**
 * 测试入口
 * Created by XKey on 2016/1/14.
 */
public class Tester {



    public static void main(String[] args) {
        ApplicationContext ctx = Utils.getContext();
        UserService userService = ctx.getBean(UserService.class);

        userService.sayHello();
    }
}
