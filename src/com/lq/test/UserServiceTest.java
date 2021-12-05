package com.lq.test;

import com.lq.pojo.User;
import com.lq.service.UserService;
import com.lq.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author qili
 * @create 2021-12-04-15:18
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "abc", "666666", "abc@163.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "admin", "admin", null));
        System.out.println(user);
    }

    @Test
    public void existsUsername() {
        boolean existsUsername = userService.existsUsername("admin123");
        if(existsUsername) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}