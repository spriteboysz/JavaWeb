package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 14:44
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class BookDAO03 {

    public boolean insertBook(Book book) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "insert into books values(null,?,?,?,?,?,?)";
        try {
            cnt = queryRunner.update(sql, book.getBookNum(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookDesc(), book.getBookStock());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean deleteBook(int bid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "delete from books where bid = ?";
        try {
            cnt = queryRunner.update(sql, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public boolean updateBook(int bid, int num) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "update books set book_stock = book_stock - ? where bid = ?";
        try {
            cnt = queryRunner.update(sql, num, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt > 0;
    }

    public Book queryBook(int bid) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        Book book = null;
        String sql = "select bid, book_num bookNum, book_name bookName, book_author bookAuthor, book_price bookPrice, book_desc bookDesc, book_stock bookStock from books where bid = ?";
        try {
            book = queryRunner.query(sql, new BeanHandler<>(Book.class), bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> queryBook() {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<Book> books = new ArrayList<>();
        String sql = "select bid, book_num bookNum, book_name bookName, book_author bookAuthor, book_price bookPrice, book_desc bookDesc, book_stock bookStock from books";
        try {
            books = queryRunner.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
