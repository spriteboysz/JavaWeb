package com.deean.servlets;

import com.deean.dto.Book;
import com.deean.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Author: Deean
 * Date: 2023-10-29 11:17
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookService();
        List<Book> books = bookService.queryBook();
        request.setAttribute("books", books);
        request.getRequestDispatcher("book-list.jsp").forward(request, response);
    }
}
