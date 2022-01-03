package com.lq.web;

import com.lq.pojo.Book;
import com.lq.pojo.Page;
import com.lq.service.BookService;
import com.lq.service.impl.BookServiceImpl;
import com.lq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qili
 * @create 2022-01-03-11:43
 */
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数pageNo, pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用bookService的page(pageNo, pageSize)方法，得到page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置page的分页条地址
        page.setUrl("client/bookServlet?action=page");
        //3.将page对象添加到request域中
        req.setAttribute("page", page);
        //4.请求转发到/pages/client/index.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    /**
     * 根据价格区间分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数pageNo, pageSize, min, max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //2.调用bookService的page(pageNo, pageSize)方法，得到page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        //设置page的分页条地址
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if(req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3.将page对象添加到request域中
        req.setAttribute("page", page);
        //4.请求转发到/pages/client/index.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
