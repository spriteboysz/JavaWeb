package com.deean.Servlets;

import com.deean.DAO.StudentDAO;
import com.deean.DTO.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-21 19:47
 * FileName: src/main/java/com/deean/Servlets
 * Description:
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sNum = request.getParameter("sNum");
        String sPassword = request.getParameter("sPassword");
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.queryStudent(sNum, sPassword);
        if (student == null) {
            request.setAttribute("tips", "用户名或密码错误，重新登录");
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            // 通过session控制授权用户登录
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60 * 2);     // session超时时间
            session.setAttribute("student", student);
            response.sendRedirect("index");
        }
    }
}
