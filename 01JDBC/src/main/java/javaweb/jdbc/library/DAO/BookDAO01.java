package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.Utils.MyDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-09-01 21:08
 * FileName: src/main/java/javaweb/jdbc/library/DAO
 * Description:
 */

public class BookDAO01 {

    public boolean insertBook(Book book) {
        int cnt = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MyDBUtils.getConnection();
            String sql = "insert into books(book_num, book_name, book_author, book_price, book_desc, book_stock) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getBookNum());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setString(3, book.getBookAuthor());
            preparedStatement.setFloat(4, book.getBookPrice());
            preparedStatement.setString(5, book.getBookDesc());
            preparedStatement.setInt(6, book.getBookStock());
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(preparedStatement, connection);
        }
        return cnt > 0;
    }

    public boolean deleteBook(int bid) {
        int cnt = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MyDBUtils.getConnection();
            String sql = "delete from books where bid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(preparedStatement, connection);
        }
        return cnt > 0;
    }

    public boolean updateBook(int bid, int stock) {
        int cnt = 0;
        Connection connection;
        PreparedStatement preparedStatement = null;
        Book book = queryBook(bid);
        try {
            connection = MyDBUtils.getConnection();
            System.out.println("修改图书信息conn:" + connection);
            String sql = "update books set book_stock = ? where bid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getBookStock() - stock);
            preparedStatement.setInt(2, bid);
            cnt = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(preparedStatement);
            // MyDBUtils.close(connection);
        }
        return cnt > 0;
    }

    public Book queryBook(int bid) {
        Book book = null;
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = MyDBUtils.getConnection();
            System.out.println("查询图书信息conn:" + connection);
            String sql = "select * from books where bid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setBid(bid);
                book.setBookNum(resultSet.getString("book_num"));
                book.setBookName(resultSet.getString("book_name"));
                book.setBookAuthor(resultSet.getString("book_author"));
                book.setBookPrice(resultSet.getFloat("book_price"));
                book.setBookDesc(resultSet.getString("book_desc"));
                book.setBookStock(resultSet.getInt("book_stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(resultSet, preparedStatement);
            // MyDBUtils.close(connection);
        }
        return book;
    }

    public List<Book> queryBook() {
        List<Book> books = new ArrayList<>();
        Connection connection;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = MyDBUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("查询图书信息conn:" + connection);
            String sql = "select * from books";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int bid = resultSet.getInt("bid");
                String bookNum = resultSet.getString("book_num");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                float bookPrice = resultSet.getFloat("book_price");
                String bookDesc = resultSet.getString("book_desc");
                int bookStock = resultSet.getInt("book_stock");
                Book book = new Book(bid, bookNum, bookName, bookAuthor, bookPrice, bookDesc, bookStock);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyDBUtils.close(resultSet, statement);
            // MyDBUtils.close(connection);
        }
        return books;
    }

}
