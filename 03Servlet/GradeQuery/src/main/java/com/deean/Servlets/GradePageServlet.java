package com.deean.Servlets;

import com.deean.DTO.Grade;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Deean
 * Date: 2023-10-21 20:55
 * FileName: src/main/java/com/deean/Servlets
 * Description:
 */

@WebServlet("/GradePageServlet")
public class GradePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Grade grade = (Grade) request.getAttribute("grade");

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

        out.println("<h3>查询结果</h3>");
        out.println("<table width = '200' border = '1' cellspacing = '0'>");
        out.println("<tr><td>学号</td><td>" + grade.getsNum() + "</td></tr>");
        out.println("<tr><td>姓名</td><td>" + grade.getsName() + "</td></tr>");
        out.println("<tr><td>课程</td><td>" + grade.getCid() + "</td></tr>");
        out.println("<tr><td>课程</td><td>" + grade.getcName() + "</td></tr>");
        out.println("<tr><td>成绩</td><td>" + grade.getScore() + "</td></tr>");
        out.println("</table>");

        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }
}
