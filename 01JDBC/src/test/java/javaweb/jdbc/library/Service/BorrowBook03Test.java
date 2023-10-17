package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO03;
import javaweb.jdbc.library.DAO.StudentDAO03;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BorrowBook03Test {
    BorrowBook03 borrowBook = new BorrowBook03();

    @Test
    void borrowBook01() {
        StudentDAO03 studentDAO = new StudentDAO03();
        Student student = studentDAO.queryStudent(2);
        BookDAO03 bookDAO = new BookDAO03();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook.borrowBook01(student, book, 2);
        assertTrue(flag);
    }

    @Test
    void borrowBook02() {
        StudentDAO03 studentDAO = new StudentDAO03();
        Student student = studentDAO.queryStudent(2);
        BookDAO03 bookDAO = new BookDAO03();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook.borrowBook02(student, book, 2);
        assertTrue(flag);
    }
}