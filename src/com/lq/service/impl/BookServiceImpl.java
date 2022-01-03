package com.lq.service.impl;

import com.lq.dao.BookDAO;
import com.lq.dao.impl.BookDAOImpl;
import com.lq.pojo.Book;
import com.lq.pojo.Page;
import com.lq.service.BookService;
import com.lq.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-17:00
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        Connection conn = JdbcUtils.getConnection();
        bookDAO.addBook(conn, book);
        JdbcUtils.close(conn);
    }

    @Override
    public void deleteBookById(Integer id) {
        Connection conn = JdbcUtils.getConnection();
        bookDAO.deleteBookById(conn, id);
        JdbcUtils.close(conn);
    }

    @Override
    public void updateBook(Book book) {
        Connection conn = JdbcUtils.getConnection();
        bookDAO.updateBook(conn, book);
        JdbcUtils.close(conn);
    }

    @Override
    public Book queryBookById(Integer id) {
        Connection conn = JdbcUtils.getConnection();
        Book book = bookDAO.queryBookById(conn, id);
        JdbcUtils.close(conn);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        Connection conn = JdbcUtils.getConnection();
        List<Book> books = bookDAO.queryBooks(conn);
        JdbcUtils.close(conn);
        return books;
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Connection conn = JdbcUtils.getConnection();
        Page<Book> page = new Page<>();

        //2.设置页面大小
        page.setPageSize(pageSize);//
        //3.得到总记录数pageTotalCount
        int pageTotalCount = bookDAO.queryForPageTotalCount(conn);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //4.得到总页码pageTotal
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        //1.设置当前页码
        page.setPageNo(pageNo);

        //5.得到当前页数据List<Book>
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> list = bookDAO.queryForItems(conn, begin, pageSize);
        //设置当前页数据
        page.setItems(list);
        JdbcUtils.close(conn);
        //返回page对象
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Connection conn = JdbcUtils.getConnection();
        Page<Book> page = new Page<>();

        //2.设置页面大小
        page.setPageSize(pageSize);
        //3.得到总记录数pageTotalCount
        int pageTotalCount = bookDAO.queryForPageTotalCountByPrice(conn, min, max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //4.得到总页码pageTotal
        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        //1.设置当前页码
        page.setPageNo(pageNo);

        //5.得到当前页数据List<Book>
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> list = bookDAO.queryForItemsByPrice(conn, begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(list);
        JdbcUtils.close(conn);
        //返回page对象
        return page;
    }
}
