package com.lq.dao;

import com.lq.pojo.User;

/**
 * @author qili
 * @create 2021-12-04-14:22
 */
public interface UserDAO {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null, 说明没有该用户
     */
    User queryUserByName(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null,说明用户名或密码错误
     */
    User queryUserByNameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return 如果返回-1表示操作失败， 否则返回sql语句影响的行数
     */
    int saveUser(User user);
}
