package com.deean.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-25 23:42
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("UserPassword");
        String userCode = request.getParameter("userCode");

        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("vCode");
        if (userCode.equals(vCode)) {
            System.out.println("验证码正确");
            if (userName.equals("001") && userPassword.equals("123456")) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或密码错误");
                request.getRequestDispatcher("login.html").forward(request, response);
            }
        } else {
            System.out.println("验证码错误");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}
