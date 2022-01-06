package com.lq.service.impl;

import com.lq.dao.BookDAO;
import com.lq.dao.impl.BookDAOImpl;
import com.lq.pojo.Book;
import com.lq.pojo.Page;
import com.lq.service.BookService;

import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-17:00
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        Book book = bookDAO.queryBookById(id);
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        List<Book> books = bookDAO.queryBooks();
        return books;
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //2.设置页面大小
        page.setPageSize(pageSize);//
        //3.得到总记录数pageTotalCount
        int pageTotalCount = bookDAO.queryForPageTotalCount();
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
        List<Book> list = bookDAO.queryForItems(begin, pageSize);
        //设置当前页数据
        page.setItems(list);
        //返回page对象
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //2.设置页面大小
        page.setPageSize(pageSize);
        //3.得到总记录数pageTotalCount
        int pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min, max);
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
        List<Book> list = bookDAO.queryForItemsByPrice(begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(list);
        //返回page对象
        return page;
    }
}
