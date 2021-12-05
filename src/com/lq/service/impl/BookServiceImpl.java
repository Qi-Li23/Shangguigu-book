package com.lq.service.impl;

import com.lq.dao.BookDAO;
import com.lq.dao.impl.BookDAOImpl;
import com.lq.pojo.Book;
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
}
