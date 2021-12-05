package com.lq.dao;

import com.lq.pojo.Book;

import java.sql.Connection;
import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-16:26
 */
public interface BookDAO {
    /**
     * 添加图书
     * @param conn
     * @param book
     * @return
     */
    int addBook(Connection conn, Book book);

    /**
     * 根据id删除图书
     * @param conn
     * @param id
     * @return
     */
    int deleteBookById(Connection conn, Integer id);

    /**
     * 更新图书
     * @param conn
     * @param book
     * @return
     */
    int updateBook(Connection conn, Book book);

    /**
     * 根据图书id查询图书
     * @param conn
     * @param id
     * @return
     */
    Book queryBookById(Connection conn, Integer id);

    /**
     * 查询所有图书
     * @param conn
     * @return
     */
    List<Book> queryBooks(Connection conn);
}
