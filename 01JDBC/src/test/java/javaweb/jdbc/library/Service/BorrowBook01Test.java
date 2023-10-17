package javaweb.jdbc.library.Service;

import javaweb.jdbc.library.DAO.BookDAO01;
import javaweb.jdbc.library.DAO.StudentDAO01;
import javaweb.jdbc.library.DTO.Book;
import javaweb.jdbc.library.DTO.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BorrowBook01Test {
    BorrowBook01 borrowBook01 = new BorrowBook01();

    @Test
    void borrowBook01() {
        StudentDAO01 studentDAO = new StudentDAO01();
        Student student = studentDAO.queryStudent(1);
        BookDAO01 bookDAO = new BookDAO01();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook01.borrowBook01(student, book, 3);
        assertTrue(flag);
    }

    @Test
    void borrowBook02() {
        StudentDAO01 studentDAO = new StudentDAO01();
        Student student = studentDAO.queryStudent(2);
        BookDAO01 bookDAO = new BookDAO01();
        Book book = bookDAO.queryBook(1);
        boolean flag = borrowBook01.borrowBook02(student, book, 2);
        assertTrue(flag);
    }
}