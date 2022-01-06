package com.lq.service.impl;

import com.lq.dao.UserDAO;
import com.lq.dao.impl.UserDAOImpl;
import com.lq.pojo.User;
import com.lq.service.UserService;

/**
 * @author qili
 * @create 2021-12-04-14:59
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registUser(User user) {
        userDAO.saveUser(user);

    }

    @Override
    public User login(User user) {
        User user1 = userDAO.queryUserByNameAndPassword(user.getUsername(), user.getPassword());
        return user1;

    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDAO.queryUserByName(username);
        if(user == null) {
            return false;
        }
        return true;
    }
}
