package com.deean.servlets;

import com.deean.dto.Book;
import com.deean.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.UUID;

/**
 * Author: Deean
 * Date: 2023-10-29 11:17
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/BookAddServlet")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
        String bookDesc = request.getParameter("bookDesc");
        int bookStock = Integer.parseInt(request.getParameter("bookStock"));
        int bookType = Integer.parseInt(request.getParameter("bookType"));

        Part bookImg = request.getPart("bookImg");
        String header = bookImg.getHeader("Content-Disposition");
        System.out.println(bookImg);
        String ext = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));
        String fileName = UUID.randomUUID() + ext;

        String path = getServletContext().getRealPath("/files");
        path += "\\" + fileName;
        bookImg.write(path);

        Book book = new Book(bookId, bookName, bookAuthor, "files/" + fileName, bookPrice, bookDesc, bookStock, bookType);
        BookService bookService = new BookService();
        boolean b = bookService.addBook(book);
        String tips = b ? "<label style='color:green'>添加图书成功</label>" : "<label style='color:red'>添加图书失败</label>";
        request.setAttribute("tips", tips);
        request.getRequestDispatcher("prompt.jsp").forward(request, response);
    }
}
