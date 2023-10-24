package com.deean.Utils;

import com.deean.DTO.Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-24 23:43
 * FileName: src/main/java/com/deean/Utils
 * Description: 登录过滤器
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
        if ("login".equals(requestPath) || "CheckServlet".equals(requestPath)) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");
            if (student == null) {
                request.setAttribute("tips", "请先登录");
                request.getRequestDispatcher("login").forward(request, response);
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
