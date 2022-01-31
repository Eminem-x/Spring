package com.yuanhao.dao;

import com.yuanhao.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
}
