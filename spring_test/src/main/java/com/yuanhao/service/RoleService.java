package com.yuanhao.service;

import com.yuanhao.domain.Role;

import java.util.List;

/**
 * @author Yuanhao
 */
public interface RoleService {
    public List<Role> list();
    public void save(Role role);
}
