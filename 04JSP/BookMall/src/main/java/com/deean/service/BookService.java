package com.deean.service;

import com.deean.dao.BookDAO;
import com.deean.dto.Book;
import com.deean.utils.PageUtil;

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

    public PageUtil<Book> queryBook(int pageCurrent, int limit) {
        int start = (pageCurrent - 1) * limit;
        List<Book> books = bookDAO.queryBook(start, limit);
        long count = bookDAO.queryBookCount();
        int pageCount = (int) Math.ceil(count * 1.0 / limit);
        return new PageUtil<>(books, pageCurrent, pageCount);
    }
}
