package com.lq.dao;

import com.lq.pojo.User;

import java.sql.Connection;

/**
 * @author qili
 * @create 2021-12-04-14:22
 */
public interface UserDAO {
    /**
     * 根据用户名查询用户信息
     * @param conn 数据库连接
     * @param username 用户名
     * @return 如果返回null, 说明没有该用户
     */
    User queryUserByName(Connection conn, String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username 用户名
     * @param conn 数据库连接
     * @param password 密码
     * @return 如果返回null,说明用户名或密码错误
     */
    User queryUserByNameAndPassword(Connection conn, String username, String password);

    /**
     * 保存用户信息
     * @param conn 数据库连接
     * @param user
     * @return 如果返回-1表示操作失败， 否则返回sql语句影响的行数
     */
    int saveUser(Connection conn, User user);
}
