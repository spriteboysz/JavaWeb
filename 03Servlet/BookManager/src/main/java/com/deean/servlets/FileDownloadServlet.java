package com.deean.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: Deean
 * Date: 2023-10-25 22:39
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("fileName");
        ServletContext servletContext = getServletContext();
        String path = servletContext.getRealPath("/files");
        path += "\\" + fileName;

        // 设置响应头
        response.setContentType("application/image");
        response.addHeader("Content-Disposition", "attachment; fileName=" + fileName);

        ServletOutputStream outputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            outputStream.write(bs, 0, len);
        }
        outputStream.close();
        fileInputStream.close();
    }
}
