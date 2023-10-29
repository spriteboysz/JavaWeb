package com.deean.servlets;

import com.deean.dto.User;
import com.deean.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-29 11:17
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userCode = request.getParameter("userCode");

        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("vCode");


        if (userCode.equals(vCode)) {
            System.out.println("验证码正确");
            UserService userService = new UserService();
            User user = userService.checkLogin(userName, userPassword);
            if (user == null) {
                request.setAttribute("tips", "<label style='color:red'>用户名或密码错误，登录失败</label>");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            }
        } else {
            System.out.println("验证码错误");
            request.setAttribute("tips", "<label style='color:red'>验证码错误</label>");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
