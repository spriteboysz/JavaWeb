package com.deean.dao;

import com.deean.dto.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookDAOTest {

    BookDAO bookDAO = new BookDAO();

    @Test
    void queryBook() {
        List<Book> books = bookDAO.QueryBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    void QueryBook() {
        String bookID = "202301";
        Book book = bookDAO.QueryBook(bookID);
        System.out.println(book);
    }

    @Test
    void insertBook() {
        Book book = new Book(
                "202302", "C++", "张三", "cc", 9.99, "HEHE", 20, 2
        );
        boolean b = bookDAO.insertBook(book);
        assert (b);
    }

    @Test
    void updateBook() {
        Book book = new Book(
                "202302", "C++", "李四", "cc", 9.99, "HEHE", 20, 2
        );
        boolean b = bookDAO.updateBook(book);
        assert (b);
    }

    @Test
    void deleteBook() {
        boolean b = bookDAO.deleteBook("202302");
        assert (b);
    }
}