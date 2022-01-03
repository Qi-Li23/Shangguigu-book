package com.lq.web;

import com.lq.pojo.Cart;
import com.lq.pojo.User;
import com.lq.service.OrderService;
import com.lq.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qili
 * @create 2022-01-03-20:15
 */
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取cart，user对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User loginUser = (User) req.getSession().getAttribute("user");
        if(loginUser == null) {
            //未登录,跳转到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }
        //createOrder(Cart cart, Integer userId)
        String orderId = orderService.createOrder(cart, loginUser.getId());
        //2.将上面方法返回的orderId保存到session域中
        req.getSession().setAttribute("orderId", orderId);
        //3.请求重定向到/pages/cart/checkout.jsp
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
