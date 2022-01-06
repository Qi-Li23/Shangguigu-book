package com.lq.dao;

import com.lq.pojo.OrderItem;

/**
 * @author qili
 * @create 2022-01-03-19:35
 */
public interface OrderItemDAO {
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);
}
