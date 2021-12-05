package com.lq.dao.impl;

import com.lq.dao.BaseDAO;
import com.lq.dao.UserDAO;
import com.lq.pojo.User;

import java.sql.Connection;

/**
 * @author qili
 * @create 2021-12-04-14:28
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User queryUserByName(Connection conn, String username) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ?";
        User user = queryForOne(conn, sql, username);
        return user;
    }

    @Override
    public User queryUserByNameAndPassword(Connection conn, String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        User user = queryForOne(conn, sql, username, password);
        return user;
    }

    @Override
    public int saveUser(Connection conn, User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?, ?, ?)";
        int update = update(conn, sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }
}
