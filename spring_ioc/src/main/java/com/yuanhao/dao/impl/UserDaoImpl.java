package com.yuanhao.dao.impl;

import com.yuanhao.dao.UserDao;

import java.io.File;

/**
 * @author Yuanhao
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl is constructed.");
    }

    public void init() {
        System.out.println("init method.");
    }

    public void destroy() {
        File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("destroy method.");
    }

    @Override
    public void save() {
        System.out.println("save running...");
    }
}
