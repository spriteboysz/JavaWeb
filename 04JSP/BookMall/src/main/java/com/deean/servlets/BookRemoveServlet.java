package com.deean.servlets;

import com.deean.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-29 11:17
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/BookRemoveServlet")
public class BookRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        BookService bookService = new BookService();
        boolean b = bookService.removeBook(bookId);
        String tips = b ? "<label style='color:green'>删除图书成功</label>" : "<label style='color:red'>删除图书失败</label>";
        request.setAttribute("tips", tips);
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }
}
