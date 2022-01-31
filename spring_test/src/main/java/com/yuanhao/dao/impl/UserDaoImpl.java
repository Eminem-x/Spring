package com.yuanhao.dao.impl;

import com.yuanhao.dao.UserDao;
import com.yuanhao.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Yuanahao
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Long save(User user) {
        Long userId = jdbcTemplate.queryForObject("select max(id) from sys_user", Long.class) + 1;

        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.CLOSE_CURRENT_RESULT);
                preparedStatement.setObject(1, userId);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void saveUserRoleRelation(Long id, Long[] roleIds) {
        for (Long roleId : roleIds) {
            jdbcTemplate.update("insert into sys_user_role values(?,?)", id, roleId);
        }
    }

    @Override
    public void deleteUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
    }

    @Override
    public void deleteUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?", userId);
    }

    @Override
    public User login(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?",new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
