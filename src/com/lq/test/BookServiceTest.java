package com.lq.test;

import com.lq.pojo.Book;
import com.lq.service.BookService;
import com.lq.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qili
 * @create 2021-12-05-17:03
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "三国演义", "罗贯中", new BigDecimal(25), 230,
                500, null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(25, "三国演义222", "罗贯中", new BigDecimal(25), 600,
                50, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(25);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        books.forEach(System.out::println);
    }
}