package com.deean.Servlets;

import com.deean.DTO.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Deean
 * Date: 2023-10-21 20:00
 * FileName: src/main/java/com/deean/Servlets
 * Description:
 */
@WebServlet("/index")
public class IndexPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        if (student == null) {
            request.setAttribute("tips", "请先登录");
            request.getRequestDispatcher("login").forward(request, response);
        }

        String tips = (String) request.getAttribute("tips");

        response.setStatus(200);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>学生成绩查询系统-主页面</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border = '1' width = '100%' height = '700'>");
        out.println("<tr height = '100'> <td colspan = '2'><label>学生成绩查询系统，欢迎你</label></td></tr>");
        out.println("<tr>");
        out.println("<td width = '200'>2-1</td>");
        out.println("<td align = 'center' valign = 'top'>");
        if (tips != null) {
            out.println("<label style='color:red'>" + tips + "</label>");
        }
        out.println("<form action = 'GradeQueryServlet' method='post'>");
        out.println("<h3>查询课程成绩</h3>");
        out.println("<p>学号：<input type='text' name='sNum' placeholder='学号'/></p>");
        out.println("<p>课程：<input type='text' name='cid' placeholder='课程号'/></p>");
        out.println("<p><input type='submit' value='查询'/></p>");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
