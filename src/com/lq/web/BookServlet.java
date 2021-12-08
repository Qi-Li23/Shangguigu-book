package com.lq.web;

import com.lq.pojo.Book;
import com.lq.service.BookService;
import com.lq.service.impl.BookServiceImpl;
import com.lq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-17:22
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，封装成Book对象
        Book book = WebUtils.copyParamtersToBean(req.getParameterMap(), new Book());
        //2.调用BookService的addBook()方法
        bookService.addBook(book);
        //3.请求转发到/manager/BookServlet?action=list
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService的queryBookById()方法
        Book book = bookService.queryBookById(id);
        //3.将book对象添加到req域中，并请求转发到pages/manager/book_edit.jsp页面
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，封装成为Book对象
        Book book = WebUtils.copyParamtersToBean(req.getParameterMap(), new Book());
        //2.调用bookService的updateBook()方法
        bookService.updateBook(book);
        //3.请求重定向到/工程路径/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService的deleteBookById()
        bookService.deleteBookById(id);
        //3.请求重定向到/book/pages/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");


    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过bookService查询到全部图书
        List<Book> books = bookService.queryBooks();
        //2.将结果添加到request域中
        req.setAttribute("books", books);
        //3.请求转发到manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
