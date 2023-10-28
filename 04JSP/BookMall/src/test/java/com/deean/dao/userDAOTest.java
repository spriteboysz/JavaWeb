package com.deean.dao;

import org.junit.jupiter.api.Test;

class UserDAOTest {

    @Test
    void queryUser() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.queryUser("admin"));
    }
}