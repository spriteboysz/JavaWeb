package com.deean.servlets;

import com.deean.dto.Book;
import jakarta.servlet.ServletContext;
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
 * Date: 2023-10-25 20:44
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookNum = request.getParameter("bookNum");
        String bookName = request.getParameter("bookName");
        Part bookCover = request.getPart("bookCover");
        System.out.println("图书编号 " + bookNum);
        System.out.println("图书名字 " + bookName);
        System.out.println("图书封面 " + bookCover);
        ServletContext servletContext = getServletContext();
        String path = servletContext.getRealPath("/files");
        System.out.println(path);
        String header = bookCover.getHeader("Content-Disposition");
        String ext  = header.substring(header.lastIndexOf("."), header.lastIndexOf("\""));
        String fileName = UUID.randomUUID() + ext;
        bookCover.write(path + "\\" + fileName);

        Book book = new Book(bookNum, bookName, "files/" + fileName);
        System.out.println(book);
    }
}
