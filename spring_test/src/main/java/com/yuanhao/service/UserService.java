package com.yuanhao.service;

import com.yuanhao.domain.User;

import java.util.List;

/**
 * @author Yuanhao
 */
public interface UserService {
    public List<User> list();

    public void save(User user, Long[] roleIds);

    void delete(Long userId);

    User login(String username, String password);
}
