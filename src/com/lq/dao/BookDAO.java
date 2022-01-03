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

    /**
     * 查询表中书的总记录数
     * @return
     */
    int queryForPageTotalCount(Connection conn);

    /**
     * 查询指定页面、指定页面大小的所有图书
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForItems(Connection conn, int begin, int pageSize);

    /**
     * 根据价格区间，查询记录数
     * @param conn
     * @param min
     * @param max
     * @return
     */
    int queryForPageTotalCountByPrice(Connection conn, int min, int max);

    /**
     *根据价格区间，查询指定页面、指定页面大小的所有图书
     * @param conn
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryForItemsByPrice(Connection conn, int begin, int pageSize, int min, int max);
}
