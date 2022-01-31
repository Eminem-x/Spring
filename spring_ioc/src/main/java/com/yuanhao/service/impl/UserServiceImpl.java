package com.yuanhao.service.impl;

import com.yuanhao.dao.UserDao;
import com.yuanhao.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Yuanhao
 * */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        saveWithInjection();
    }

    private void saveWithInjection() {
        userDao.save();
    }

    private void saveWithOutInjection() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
