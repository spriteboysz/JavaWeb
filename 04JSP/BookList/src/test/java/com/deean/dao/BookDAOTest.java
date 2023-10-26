package com.deean.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookDAOTest {

    @Test
    void queryBook() {
        BookDAO bookDAO = new BookDAO();
        System.out.println(bookDAO.queryBook().size());
        assertNotNull(bookDAO.queryBook());
    }
}