package com.lq.dao.impl;

import com.lq.dao.BaseDAO;
import com.lq.dao.UserDAO;
import com.lq.pojo.User;

/**
 * @author qili
 * @create 2021-12-04-14:28
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User queryUserByName(String username) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ?";
        User user = queryForOne(sql, username);
        return user;
    }

    @Override
    public User queryUserByNameAndPassword(String username, String password) {
        String sql = "select `id`, `username`, `password`, `email` from t_user where username = ? and password = ?";
        User user = queryForOne(sql, username, password);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?, ?, ?)";
        int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update;
    }
}
