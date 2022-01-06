package com.lq.test;

import com.lq.dao.OrderDAO;
import com.lq.dao.impl.OrderDAOImpl;


/**
 * @author qili
 * @create 2022-01-03-19:38
 */
public class OrderDAOTest {
    private OrderDAO orderDAO = new OrderDAOImpl();

//    @Test
//    public void saveOrder() {
//        Connection connection = JdbcUtils.getConnection();
//        orderDAO.saveOrder(connection, new Order("1234567890", new Date(), new BigDecimal(100), 0, 2));
//        JdbcUtils.close(connection);
//    }
}