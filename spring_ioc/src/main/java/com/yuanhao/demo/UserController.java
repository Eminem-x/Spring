package com.yuanhao.demo;

import com.yuanhao.service.UserService;
import com.yuanhao.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yuanhao
 */
public class UserController {
    public static void main(String[] args) {
        new UserController().controlWithSpring();
    }

    public void controlWithoutSpring() {
        UserService userService = new UserServiceImpl();
        userService.save();
    }

    public void controlWithSpring() {
        // 如果不通过容器直接调用 会出现空指针异常
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
