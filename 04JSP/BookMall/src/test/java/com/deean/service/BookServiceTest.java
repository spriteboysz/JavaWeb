package com.deean.service;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    @Test
    void addBook() {
    }

    @Test
    void removeBook() {
    }

    @Test
    void modifyBook() {
    }

    @Test
    void queryBook() {
        BookService bookService = new BookService();
        System.out.println(bookService.queryBook("202301"));
    }

    @Test
    void testQueryBook() {
        BookService bookService = new BookService();
        System.out.println(bookService.queryBook());
    }
}