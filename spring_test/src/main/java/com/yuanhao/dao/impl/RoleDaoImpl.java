package com.yuanhao.dao.impl;

import com.yuanhao.dao.RoleDao;
import com.yuanhao.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Yuanhao
 */
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        Long id = jdbcTemplate.queryForObject("select max(id) from sys_role", Long.class) + 1;
        jdbcTemplate.update("insert into sys_role values(?,?,?)", id, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleById(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur, sys_role r where ur.userId=? and ur.roleId = r.id", new BeanPropertyRowMapper<>(Role.class), id);
        return roles;
    }
}
