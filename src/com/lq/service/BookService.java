package com.lq.service;

import com.lq.pojo.Book;

import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-16:57
 */
public interface BookService {
    /**
     * 增加图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     */
    void deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks();

}
