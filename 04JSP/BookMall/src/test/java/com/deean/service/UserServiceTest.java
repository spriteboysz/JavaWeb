package com.deean.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void checkLogin() {
        UserService userService = new UserService();
        System.out.println(userService.checkLogin("admin", "123456"));
        assertNull(userService.checkLogin("admin", "123"));
        assertNotNull(userService.checkLogin("admin", "123456"));

    }
}