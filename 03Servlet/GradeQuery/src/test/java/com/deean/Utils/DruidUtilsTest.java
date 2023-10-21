package com.deean.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DruidUtilsTest {

    @Test
    void getConnection() {
        assertNotNull(DruidUtils.getConnection());
        System.out.println(DruidUtils.getConnection());
    }

    @Test
    void getDataSource() {
        assertNotNull(DruidUtils.getDataSource());
        System.out.println(DruidUtils.getDataSource());
    }
}