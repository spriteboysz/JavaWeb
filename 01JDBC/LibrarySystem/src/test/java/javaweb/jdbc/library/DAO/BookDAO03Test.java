package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookDAO03Test {
    BookDAO03 bookDAO = new BookDAO03();
    @Test
    void insertStudent() {
        Book book = new Book(0, "20130101", "算法导论", "KK", 218, "一代神书", 20);
        boolean flag = bookDAO.insertBook(book);
        assertTrue(flag);
    }

    @Test
    void deleteBook() {
        boolean flag = bookDAO.deleteBook(17);
        assertTrue(flag);
    }

    @Test
    void updateBook() {
        boolean flag = bookDAO.updateBook(1, 2);
        assertTrue(flag);
    }

    @Test
    void queryBook() {
        Book book = bookDAO.queryBook(1);
        System.out.println(book);
    }

    @Test
    void queryBookAll() {
        List<Book> books = bookDAO.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}