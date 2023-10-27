package com.deean.servlets;

import com.deean.dao.GradeDAO;
import com.deean.dto.Grade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-27 22:49
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/GradeQueryServlet")
public class GradeQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sNum = request.getParameter("sNum");
        String cid = request.getParameter("cid");

        GradeDAO gradeDAO = new GradeDAO();
        Grade grade = gradeDAO.queryGrade(sNum, cid);

        if (grade == null) {
            request.setAttribute("tips", "用户ID或课程ID错误，重新输入");
            request.getRequestDispatcher("index").forward(request, response);
        } else {
            request.setAttribute("grade", grade);
            request.getRequestDispatcher("grade.jsp").forward(request, response);
        }
    }
}
