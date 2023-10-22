package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BookDAO02Test {
    BookDAO02 bookDAO = new BookDAO02();

    @Test
    void queryBook() {
        Book book = bookDAO.queryBook(1);
        System.out.println(book);

        List<Book> books = bookDAO.queryBook();
        for (Book b : books) {
            System.out.println(b);
        }
    }

    @Test
    void insertBook() {
        Book book = new Book(0, "20130101", "算法导论", "KK", 218, "一代神书", 20);
        boolean flag = bookDAO.insertBook(book);
        assertTrue(flag);
    }

    @Test
    void deleteBook() {
        boolean flag = bookDAO.deleteBook(14);
        assertTrue(flag);
    }

    @Test
    void updateBook() {
        boolean flag = bookDAO.updateBook(2, 2);
        assertTrue(flag);
    }
}