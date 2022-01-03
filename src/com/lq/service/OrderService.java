package com.lq.service;

import com.lq.pojo.Cart;

/**
 * @author qili
 * @create 2022-01-03-19:54
 */
public interface OrderService {
    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return 返回订单号
     */
    String createOrder(Cart cart, Integer userId);
}

