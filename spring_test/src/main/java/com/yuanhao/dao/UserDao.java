package com.yuanhao.dao;

import com.yuanhao.domain.User;

import java.util.List;

/**
 * @author Yuanaho
 */
public interface UserDao {
    public List<User> findAll();

    Long save(User user);

    void saveUserRoleRelation(Long id, Long[] roleIds);

    void deleteUserRole(Long userId);

    void deleteUser(Long userId);

    User login(String username, String password);
}
