package com.lq.dao;

import com.lq.pojo.Order;

import java.sql.Connection;

/**
 * @author qili
 * @create 2022-01-03-19:29
 */
public interface OrderDAO {

    /**
     * 添加订单
     * @param order
     * @param conn
     * @return
     */
    int saveOrder(Connection conn, Order order);
}
