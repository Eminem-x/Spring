package com.yuanhao.service.impl;

import com.yuanhao.dao.UserDao;
import com.yuanhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//@Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    private String driver;

//    @Autowired //按照数据类型从 Spring 容器中进行匹配
//    @Qualifier("userDao") //按照 id 值从容器中进行匹配 但是要结合@Autowired使用
    @Resource(name="userDao") //相当于 @Autowired + @Qualifier
    private UserDao userDao;

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }
}
