package com.yuanhao.mapper;

import com.yuanhao.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findByCondition(User user);
}
