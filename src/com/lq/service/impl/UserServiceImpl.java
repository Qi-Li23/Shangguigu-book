package com.lq.service.impl;

import com.lq.dao.UserDAO;
import com.lq.dao.impl.UserDAOImpl;
import com.lq.pojo.User;
import com.lq.service.UserService;
import com.lq.utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author qili
 * @create 2021-12-04-14:59
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registUser(User user) {
        Connection conn = JdbcUtils.getConnection();
        userDAO.saveUser(conn, user);
        JdbcUtils.close(conn);

    }

    @Override
    public User login(User user) {
        Connection conn = JdbcUtils.getConnection();
        User user1 = userDAO.queryUserByNameAndPassword(conn, user.getUsername(), user.getPassword());
        JdbcUtils.close(conn);
        return user1;

    }

    @Override
    public boolean existsUsername(String username) {
        Connection conn = JdbcUtils.getConnection();
        User user = userDAO.queryUserByName(conn, username);
        if(user == null) {
            return false;
        }
        JdbcUtils.close(conn);
        return true;
    }
}
