package com.deean.dao;

import com.deean.dto.Book;
import com.deean.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-10-28 21:16
 * FileName: src/main/java/com/deean/dao
 * Description:
 */

public class BookDAO {
    public List<Book> queryBook() {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = """
                select book_id     bookId,
                       book_name   bookName,
                       book_author bookAuthor,
                       book_cover  bookCover,
                       book_price  bookPrice,
                       book_desc   bookDesc,
                       book_stock  bookStock,
                       book_type   bookType
                from books""";
        List<Book> books;
        try {
            books = queryRunner.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public Book queryBook(String bookId) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        String sql = """
                select book_id     bookId,
                       book_name   bookName,
                       book_author bookAuthor,
                       book_cover  bookCover,
                       book_price  bookPrice,
                       book_desc   bookDesc,
                       book_stock  bookStock,
                       book_type   bookType
                from books
                where book_id=?""";
        Book book = null;
        try {
            book = queryRunner.query(sql, new BeanHandler<>(Book.class), bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    public boolean insertBook(Book book) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "insert into books values(?,?,?,?,?,?,?,?)";
        try {
            cnt = queryRunner.update(sql,
                    book.getBookId(),
                    book.getBookName(),
                    book.getBookAuthor(),
                    book.getBookCover(),
                    book.getBookPrice(),
                    book.getBookDesc(),
                    book.getBookStock(),
                    book.getBookType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt > 0;
    }

    public boolean updateBook(Book book) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = """
                update books
                set book_name=?,
                    book_author=?,
                    book_cover=?,
                    book_price=?,
                    book_desc=?,
                    book_stock=?,
                    book_type=?
                where book_id=?""";
        try {
            cnt = queryRunner.update(sql,
                    book.getBookName(),
                    book.getBookAuthor(),
                    book.getBookCover(),
                    book.getBookPrice(),
                    book.getBookDesc(),
                    book.getBookStock(),
                    book.getBookType(),
                    book.getBookId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt > 0;
    }

    public boolean deleteBook(String bookId) {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int cnt = 0;
        String sql = "delete from books where book_id = ?";
        try {
            cnt = queryRunner.update(sql, bookId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cnt > 0;
    }

}
