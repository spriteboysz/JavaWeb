package com.deean.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DruidUtilsTest {

    @Test
    void getConnection() {
        System.out.println(DruidUtils.getConnection());
        assertNotNull(DruidUtils.getConnection());
    }

    @Test
    void getDataSource() {
        assertNotNull(DruidUtils.getDataSource());
    }
}