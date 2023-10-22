package javaweb.jdbc.library.DAO;

import javaweb.jdbc.library.DTO.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAO01Test {
    BookDAO01 bookDAO = new BookDAO01();

    @Test
    void queryBook() {
        int bid = 1;
        Book book = bookDAO.queryBook(bid);
        System.out.println(book);
        assertEquals(bid, book.getBid());
        List<Book> books = bookDAO.queryBook();
        for (Book b : books) {
            System.out.println(b);
        }
        assertEquals(books.size(), 3);
    }

    @Test
    void insertBook() {
        Book book = new Book(0, "20130101", "算法导论", "KK", 218, "一代神书", 20);
        boolean flag = bookDAO.insertBook(book);
        assertTrue(flag);
    }

    @Test
    void deleteBook() {
        boolean flag = bookDAO.deleteBook(3);
        assert (flag);
    }

    @Test
    void updateBook() {
        boolean flag = bookDAO.updateBook(1, 2);
        assert (flag);
    }
}