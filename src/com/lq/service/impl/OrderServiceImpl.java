package com.lq.service.impl;

import com.lq.dao.BookDAO;
import com.lq.dao.OrderDAO;
import com.lq.dao.OrderItemDAO;
import com.lq.dao.impl.BookDAOImpl;
import com.lq.dao.impl.OrderDAOImpl;
import com.lq.dao.impl.OrderItemDAOImpl;
import com.lq.pojo.*;
import com.lq.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author qili
 * @create 2022-01-03-19:56
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        //创建订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //1.创建order对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //2.调用OrderDAO方法saveOrder()保存
        orderDAO.saveOrder(order);
//        int i = 12 / 0;
        //3.遍历购物车中的Items并分别创建对应的OrderItem,
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            //4.调用orderItemDAO方法saveOrderItem()将orderItems保存到数据库
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            orderItemDAO.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDAO.updateBook(book);
        }
        ///5.清空购物车
        cart.clearCart();

        return orderId;
    }
}
