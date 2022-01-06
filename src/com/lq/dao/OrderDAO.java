package com.lq.dao;

import com.lq.pojo.Order;

/**
 * @author qili
 * @create 2022-01-03-19:29
 */
public interface OrderDAO {

    /**
     * 添加订单
     * @param order
     * @return
     */
    int saveOrder(Order order);
}
