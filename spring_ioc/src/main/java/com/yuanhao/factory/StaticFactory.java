package com.yuanhao.factory;

import com.yuanhao.dao.UserDao;
import com.yuanhao.dao.impl.UserDaoImpl;

/**
 * @author Yuanhao
 */
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
