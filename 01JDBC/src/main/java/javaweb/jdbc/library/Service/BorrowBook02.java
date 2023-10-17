package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO02;
import javaweb.jdbc.library.DAO.RecordDAO02;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-09-02 14:10
 * FileName: src/main/java/javaweb/jdbc/library/Service
 * Description:
 */

public class BorrowBook02 {
    public boolean borrowBook01(Student student, Book book, int num) {
        BookDAO02 bookDAO = new BookDAO02();
        boolean flag1 = bookDAO.updateBook(book.getBid(), num);

        RecordDAO02 recordDAO = new RecordDAO02();
        Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-9-2");
        boolean flag2 = recordDAO.insertRecord(record);
        return flag1 && flag2;
    }

    public boolean borrowBook02(Student student, Book book, int num) {
        Connection connection = null;
        boolean flag1 = false, flag2 = false;
        try {
            connection = DruidUtils.getConnection();
            connection.setAutoCommit(false);
            BookDAO02 bookDAO = new BookDAO02();
            flag1 = bookDAO.updateBook(book.getBid(), num);
            // int error = 10 / 0;
            RecordDAO02 recordDAO = new RecordDAO02();
            Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-9-2");
            flag2 = recordDAO.insertRecord(record);
            if (flag1 && flag2) {
                connection.commit();
            }
        } catch (Exception e) {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return flag1 && flag2;
    }
}
