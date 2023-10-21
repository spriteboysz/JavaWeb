package com.deean.DAO;

import com.deean.DTO.Grade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GradeDAOTest {

    @Test
    void queryGrade() {
        GradeDAO gradeDAO = new GradeDAO();
        String sNum = "20230001", cid = "20231001";
        Grade grade = gradeDAO.queryGrade(sNum, cid);
        System.out.println(gradeDAO.queryGrade(sNum, cid));
        assertNotNull(grade);
    }
}