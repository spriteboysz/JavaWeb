package com.deean.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Deean
 * Date: 2023-11-01 21:57
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
        boolean valid = !userName.startsWith("admin") && !userName.isEmpty();
        System.out.println(valid);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String ss = valid ? "{\"code\":1000,\"msg\":\"success\"}" : "{\"code\":1001,\"msg\":\"fail\"}";
        PrintWriter out = resp.getWriter();
        out.println(ss);
        out.flush();
        out.close();
    }
}
