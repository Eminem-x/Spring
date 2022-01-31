package com.yuanhao.service.impl;

import com.yuanhao.dao.RoleDao;
import com.yuanhao.dao.UserDao;
import com.yuanhao.domain.Role;
import com.yuanhao.domain.User;
import com.yuanhao.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @author Yuanhao
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            Long id = user.getId();
            List<Role> roles = roleDao.findRoleById(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRelation(userId, roleIds);
    }

    @Override
    public void delete(Long userId) {
        userDao.deleteUserRole(userId);
        userDao.deleteUser(userId);
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = userDao.login(username, password);
            return user;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
