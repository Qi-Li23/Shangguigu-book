package com.lq.dao;

import com.lq.pojo.OrderItem;

import java.sql.Connection;

/**
 * @author qili
 * @create 2022-01-03-19:35
 */
public interface OrderItemDAO {
    /**
     * 保存订单项
     * @param conn
     * @param orderItem
     * @return
     */
    int saveOrderItem(Connection conn, OrderItem orderItem);
}
