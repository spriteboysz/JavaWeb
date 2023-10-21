package com.deean.Servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Deean
 * Date: 2023-10-21 18:41
 * FileName: src/main/java/com/deean/Servlets
 * Description:
 */
@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统-登录</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<from action = '' method='post'>");
        out.println("<h3>学生成绩查询系统-学生登录</h3>");
        out.println("<p>学号：<input type='text' name='sNum' placeholder='学号'/></p>");
        out.println("<p>密码：<input type='password' name='sPassword' placeholder='密码'/></p>");
        out.println("<p><input type='submit' value='登录'/></p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
