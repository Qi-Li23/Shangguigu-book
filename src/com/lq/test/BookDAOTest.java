package com.lq.test;

import com.lq.dao.BookDAO;
import com.lq.dao.impl.BookDAOImpl;

/**
 * @author qili
 * @create 2021-12-05-16:45
 */
public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();

//    @Test
//    public void addBook() {
//        Connection conn = JdbcUtils.getConnection();
//        int i = bookDAO.addBook(conn, new Book(null, "水浒传", "施耐庵", new BigDecimal(20.1), 52,
//                105, null));
//        System.out.println(i);
//        JdbcUtils.close(conn);
//
//    }
//
//    @Test
//    public void deleteBookById() {
//        Connection conn = JdbcUtils.getConnection();
//        int i = bookDAO.deleteBookById(conn, 22);
//        System.out.println(i);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void updateBook() {
//        Connection conn = JdbcUtils.getConnection();
//        int i = bookDAO.updateBook(conn, new Book(21, "红楼梦", "曹雪芹", new BigDecimal(23.5), 500,
//                10, null));
//        System.out.println(i);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void queryBookById() {
//        Connection conn = JdbcUtils.getConnection();
//        Book book = bookDAO.queryBookById(conn, 15);
//        System.out.println(book);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void queryBooks() {
//        Connection conn = JdbcUtils.getConnection();
//        List<Book> books = bookDAO.queryBooks(conn);
//        System.out.println(books);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void testQueryForPageTotalCount() {
//        Connection conn = JdbcUtils.getConnection();
//        int totalCount = bookDAO.queryForPageTotalCount(conn);
//        System.out.println(totalCount);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void testQueryForItems() {
//        Connection conn = JdbcUtils.getConnection();
//        List<Book> books = bookDAO.queryForItems(conn, 0, 4);
//        books.forEach(System.out :: println);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void testQueryForPageTotalCountByPrice() {
//        Connection conn = JdbcUtils.getConnection();
//        int totalCount = bookDAO.queryForPageTotalCountByPrice(conn, 10, 50);
//        System.out.println(totalCount);
//        JdbcUtils.close(conn);
//    }
//
//    @Test
//    public void testQueryForItemsByPrice() {
//        Connection conn = JdbcUtils.getConnection();
//        List<Book> books = bookDAO.queryForItemsByPrice(conn, 0, 4, 10, 50);
//        books.forEach(System.out :: println);
//        JdbcUtils.close(conn);
//    }

}