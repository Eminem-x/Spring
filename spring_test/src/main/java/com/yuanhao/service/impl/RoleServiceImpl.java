package com.yuanhao.service.impl;

import com.yuanhao.dao.RoleDao;
import com.yuanhao.domain.Role;
import com.yuanhao.service.RoleService;

import java.util.List;

/**
 * @author Yuanhao
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList = roleDao.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
