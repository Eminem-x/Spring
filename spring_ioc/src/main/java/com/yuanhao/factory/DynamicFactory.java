package com.yuanhao.factory;

import com.yuanhao.dao.UserDao;
import com.yuanhao.dao.impl.UserDaoImpl;

/**
 * @author Yuanhao
 */
public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
