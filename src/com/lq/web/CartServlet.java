package com.lq.web;

import com.lq.pojo.Book;
import com.lq.pojo.Cart;
import com.lq.pojo.CartItem;
import com.lq.service.BookService;
import com.lq.service.impl.BookServiceImpl;
import com.lq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qili
 * @create 2022-01-03-15:44
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 添加商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要添加到购物车的图书id
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.根据id得到图书book对象
        Book book = bookService.queryBookById(id);
        //3.根据book对象创建CartItem对象
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //4.将cartItem对象添加到购物车中
        //得到购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null) {
            //创建购物车
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        System.out.println(cart);
        //5.重定向到首页
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取要删除的商品的编号id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.得到cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //3.通过cart的方法deleteItem()
        if(cart != null) {
            cart.deleteItem(id);
            //4.重定向到原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //2.调用cart的方法clearCart()
        if(cart != null) {
            cart.clearCart();
            //3.重定向到原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 修改商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数 商品数量count, 商品id
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //3.调用购物车对象方法updateCount()
        if(cart != null) {
            cart.updateCount(id, count);
            //4.重定向到原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }
}
