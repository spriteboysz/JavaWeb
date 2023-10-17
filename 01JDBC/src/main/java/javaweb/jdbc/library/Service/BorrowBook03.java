package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO03;
import javaweb.jdbc.library.DAO.RecordDAO03;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Record;
import javaweb.jdbc.library.DTO.Student;
import javaweb.jdbc.library.Utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Deean
 * Date: 2023-09-02 21:34
 * FileName: src/main/java/javaweb/jdbc/library/Service
 * Description:
 */

public class BorrowBook03 {
    public boolean borrowBook01(Student student, Book book, int num) {
        BookDAO03 bookDAO = new BookDAO03();
        boolean flag1 = bookDAO.updateBook(book.getBid(), num);

        RecordDAO03 recordDAO = new RecordDAO03();
        Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-9-2");
        boolean flag2 = recordDAO.insertRecord(record);
        return flag1 && flag2;
    }

    public boolean borrowBook02(Student student, Book book, int num) {
        boolean flag1 = false, flag2 = false;
        DataSource dataSource = DruidUtils.getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            BookDAO03 bookDAO = new BookDAO03();
            flag1 = bookDAO.updateBook(book.getBid(), num);
            // int error = 10 / 0;
            RecordDAO03 recordDAO = new RecordDAO03();
            Record record = new Record(0, student.getStuNum(), book.getBookNum(), num, "2023-9-2");
            flag2 = recordDAO.insertRecord(record);
            if (flag1 && flag2) {
                DbUtils.commitAndCloseQuietly(connection);
            }
        } catch (SQLException e) {
            DbUtils.rollbackAndCloseQuietly(connection);
            e.printStackTrace();
        }
        return flag1 && flag2;
    }
}
