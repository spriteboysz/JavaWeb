package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO01;
import javaweb.jdbc.library.DAO.RecordDAO01;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.MyDBUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-09-01 22:53
 * FileName: src/main/java/javaweb/jdbc/library/Service
 * Description:
 */

public class BorrowBook01 {

    public boolean borrowBook01(Student student, Book book, int num) {
        BookDAO01 bookDAO = new BookDAO01();
        boolean flag1 = bookDAO.updateBook(book.getBid(), num);

        RecordDAO01 recordDAO = new RecordDAO01();
        Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-08-30");
        boolean flag2 = recordDAO.insertRecord(record);
        return flag1 && flag2;
    }
    public boolean borrowBook02(Student student, Book book, int num) {
        boolean flag1 = false, flag2 = false;
        Connection connection = null;
        try {
            connection = MyDBUtils.getConnection();
            connection.setAutoCommit(false);
            BookDAO01 bookDAO = new BookDAO01();
            flag1 = bookDAO.updateBook(book.getBid(), num);
            // int error = 1 / 0; // 制造异常，测试事务
            RecordDAO01 recordDAO = new RecordDAO01();
            Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-08-30");
            flag2 = recordDAO.insertRecord(record);
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            MyDBUtils.close(connection);
        }
        return flag1 && flag2;
    }
}
