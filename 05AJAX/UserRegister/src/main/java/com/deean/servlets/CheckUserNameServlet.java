package com.deean.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Deean
 * Date: 2023-10-30 23:57
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/CheckUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        boolean valid = !userName.startsWith("admin");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        String str = valid ? "<label style='color:green'>用户名可用</label>" : "<label style='color:red'>用户名可用</label>";
        out.println(str);
        out.flush();
        out.close();
    }
}
