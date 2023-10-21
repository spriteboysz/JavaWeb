package com.deean.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class StudentDAOTest {

    @Test
    void queryStudent() {
        String sNum = "20230001";
        StudentDAO studentDAO = new StudentDAO();
        System.out.println(studentDAO.queryStudent(sNum, "123456").getsName());
        assertNotNull(studentDAO.queryStudent(sNum, "123456"));
        assertNull(studentDAO.queryStudent(sNum, "123457"));
    }
}