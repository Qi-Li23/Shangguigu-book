package com.lq.dao;

import com.lq.pojo.Book;

import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-16:26
 */
public interface BookDAO {
    /**
     * 添加图书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     * 更新图书
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 根据图书id查询图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();

    /**
     * 查询表中书的总记录数
     * @return
     */
    int queryForPageTotalCount();

    /**
     * 查询指定页面、指定页面大小的所有图书
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForItems(int begin, int pageSize);

    /**
     * 根据价格区间，查询记录数
     * @param min
     * @param max
     * @return
     */
    int queryForPageTotalCountByPrice(int min, int max);

    /**
     *根据价格区间，查询指定页面、指定页面大小的所有图书
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max);
}
