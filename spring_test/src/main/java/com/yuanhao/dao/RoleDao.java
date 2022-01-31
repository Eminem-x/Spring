package com.yuanhao.dao;

import com.yuanhao.domain.Role;

import java.util.List;

/**
 * @author Yuanhao
 */
public interface RoleDao {
    public List<Role> findAll();
    public void save(Role role);
    public List<Role> findRoleById(Long id);
}
