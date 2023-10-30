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

    public PageUtil<Book> queryBook(int pageCurrent, int pageSize) {
        int start = (pageCurrent - 1) * pageSize;
        List<Book> books = bookDAO.queryBook(start, pageSize);
        long count = bookDAO.queryBookCount();
        long pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
        return new PageUtil<>(books, pageCurrent, (int) pageCount);
    }
}
