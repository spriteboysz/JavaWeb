package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO02;
import javaweb.jdbc.library.DAO.StudentDAO02;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BorrowBook02Test {

    BorrowBook02 borrowBook = new BorrowBook02();

    @Test
    void borrowBook01() {
        StudentDAO02 studentDAO = new StudentDAO02();
        Student student = studentDAO.queryStudent(2);
        BookDAO02 bookDAO = new BookDAO02();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook.borrowBook01(student, book, 2);
        assertTrue(flag);
    }

    @Test
    void borrowBook02() {
        StudentDAO02 studentDAO = new StudentDAO02();
        Student student = studentDAO.queryStudent(2);
        BookDAO02 bookDAO = new BookDAO02();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook.borrowBook02(student, book, 2);
        assertTrue(flag);
    }
}