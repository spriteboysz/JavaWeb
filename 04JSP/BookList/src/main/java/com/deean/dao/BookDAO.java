package com.deean.dao;

import com.deean.dto.Book;
import com.deean.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-10-26 22:54
 * FileName: src/main/java/com/deean/dao
 * Description:
 */

public class BookDAO {
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
