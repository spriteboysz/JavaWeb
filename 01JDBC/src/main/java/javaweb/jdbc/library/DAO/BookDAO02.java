package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.Utils.CommonDAO;
import javaweb.jdbc.library.Utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-02 10:16
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class BookDAO02 {
    final CommonDAO<Book> commonDAO = new CommonDAO<>();

    public boolean insertBook(Book book) {
        String sql = "insert into books(book_num, book_name, book_author, book_price, book_desc, book_stock) values(?,?,?,?,?,?)";
        return commonDAO.update(sql, book.getBookNum(), book.getBookName(), book.getBookAuthor(), book.getBookPrice(), book.getBookDesc(), book.getBookStock());
    }

    public boolean deleteBook(int bid) {
        String sql = "delete from books where bid = ?";
        return commonDAO.update(sql, bid);
    }

    public boolean updateBook(int bid, int stock) {
        String sql = "update books set book_stock = book_stock - ? where bid = ?";
        return commonDAO.update(sql, stock, bid);
    }

    public Book queryBook(int bid) {
        String sql = "select * from books where bid = ?";
        RowMapper<Book> rowMapper = (ResultSet resultSet) -> {
            Book book = new Book();
            try {
                book.setBid(bid);
                book.setBookNum(resultSet.getString("book_num"));
                book.setBookName(resultSet.getString("book_name"));
                book.setBookAuthor(resultSet.getString("book_author"));
                book.setBookPrice(resultSet.getFloat("book_price"));
                book.setBookDesc(resultSet.getString("book_desc"));
                book.setBookStock(resultSet.getInt("book_stock"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return book;
        };
        return commonDAO.query(sql, rowMapper, bid).get(0);
    }

    public List<Book> queryBook(){
        String sql = "select * from books";
        RowMapper<Book> rowMapper = (ResultSet resultSet) -> {
            Book book = new Book();
            try {
                book.setBid(resultSet.getInt("bid"));
                book.setBookNum(resultSet.getString("book_num"));
                book.setBookName(resultSet.getString("book_name"));
                book.setBookAuthor(resultSet.getString("book_author"));
                book.setBookPrice(resultSet.getFloat("book_price"));
                book.setBookDesc(resultSet.getString("book_desc"));
                book.setBookStock(resultSet.getInt("book_stock"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return book;
        };
        return commonDAO.query(sql, rowMapper);
    }

    public static void main(String[] args) {
        BookDAO02 bookDAO = new BookDAO02();
        Book book = bookDAO.queryBook(1);
        System.out.println(book);
    }
}
