package com.deean.service;

import com.deean.dao.BookDAO;
import com.deean.dto.Book;

import java.util.List;

/**
 * Author: Deean
 * Date: 2023-10-29 10:56
 * FileName: src/main/java/com/deean/service
 * Description: 图书管理业务
 */

public class BookService {
    BookDAO bookDAO = new BookDAO();

    public boolean addBook(Book book) {
        return bookDAO.insertBook(book);
    }

    public boolean removeBook(String bookId) {
        return bookDAO.deleteBook(bookId);
    }

    public boolean modifyBook(Book book) {
        return bookDAO.updateBook(book);
    }

    public Book queryBook(String bookId) {
        return bookDAO.queryBook(bookId);
    }

    public List<Book> queryBook() {
        return bookDAO.queryBook();
    }
}
