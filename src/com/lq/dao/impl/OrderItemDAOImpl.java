package com.lq.dao.impl;

import com.lq.dao.BaseDAO;
import com.lq.dao.OrderItemDAO;
import com.lq.pojo.OrderItem;

import java.sql.Connection;

/**
 * @author qili
 * @create 2022-01-03-19:35
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(Connection conn, OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`, `count`, `price`, `total_price`, `order_id`)" +
                "values(?,?,?,?,?)";
        int update = update(conn, sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
        return update;
    }
}
