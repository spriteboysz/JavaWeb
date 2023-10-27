package com.deean.utils;

import com.deean.dto.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-27 22:53
 * FileName: src/main/java/com/deean/utils
 * Description:
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        String requestPath = uri.substring(uri.lastIndexOf("/") + 1);
        if ("login.jsp".equals(requestPath) || "CheckServlet".equals(requestPath)) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");
            if (student == null) {
                request.setAttribute("tips", "请先登录");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
