package com.lq.service;

import com.lq.pojo.User;

/**
 * @author qili
 * @create 2021-12-04-14:56
 */
public interface UserService {
    /**
     * 注册
     * @param user
     */
    void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null, 表明登录失败，否则登录成功
     */
    User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return 如果返回true,表明用户名已存在，否则表明用户名可用
     */
    boolean existsUsername(String username);
}
