package com.lq.test;

import com.lq.dao.OrderItemDAO;
import com.lq.dao.impl.OrderItemDAOImpl;
import com.lq.pojo.OrderItem;
import com.lq.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author qili
 * @create 2022-01-03-19:45
 */
public class OrderItemDAOTest {
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        Connection connection = JdbcUtils.getConnection();
        //orderItemDAO.saveOrderItem(connection, new OrderItem(null, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDAO.saveOrderItem(connection, new OrderItem(null, "javascript从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDAO.saveOrderItem(connection, new OrderItem(null, "c语言", 2, new BigDecimal(50), new BigDecimal(100), "1234567890"));
        JdbcUtils.close(connection);
    }
}