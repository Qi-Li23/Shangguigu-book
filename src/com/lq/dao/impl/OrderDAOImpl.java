package com.lq.dao.impl;

import com.lq.dao.BaseDAO;
import com.lq.dao.OrderDAO;
import com.lq.pojo.Order;

import java.sql.Connection;

/**
 * @author qili
 * @create 2022-01-03-19:30
 */
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Connection conn, Order order) {
        //1.sql语句
        String sql = "insert into t_order(`order_id`, `create_time`, `price`, `status`, `user_id`)" +
                "values(?,?,?,?,?)";
        //2.调用update()
        int update = update(conn, sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        return update;
    }
}
