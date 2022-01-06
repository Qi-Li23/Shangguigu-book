package com.lq.dao.impl;

import com.lq.dao.BaseDAO;
import com.lq.dao.BookDAO;
import com.lq.pojo.Book;

import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-16:30
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name`, `author`, `price`, `sales`, `stock`, `img_path`) " +
                "values(?, ?, ?, ?, ?, ?)";
        int update = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath());
        return update;
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        int update = update(sql, id);
        return update;
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?, author = ?, price = ?, sales = ?, stock = ?, img_path = ? " +
                "where id = ?";
        int update = update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath(), book.getId());
        return update;
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` imgPath from t_book where id = ?";
        Book book = queryForOne(sql, id);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, `img_path` imgPath from t_book";
        List<Book> books = queryForList(sql);
        return books;
    }

    @Override
    public int queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number value = (Number) queryForSingleValue(sql);
        return value.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, " +
                 "`img_path` imgPath from t_book limit ?, ?";
        List<Book> list = queryForList(sql, begin, pageSize);
        return list;
    }

    @Override
    public int queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number value = (Number) queryForSingleValue(sql, min, max);
        return value.intValue();
    }

    @Override
    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock`, " +
                "`img_path` imgPath from t_book where price between ? and ? order by price limit ?, ?";
        List<Book> list = queryForList(sql, min, max, begin, pageSize);
        return list;
    }
}
