package com.deean.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Author: Deean
 * Date: 2023-10-29 21:50
 * FileName: src/main/java/com/deean/servlets
 * Description:
 */

@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 300, height = 90;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(getRandomColor());
        graphics.fillRect(0, 0, width, height);

        int letterNum = 4, space = 20;
        int letterWidth = (width - (letterNum + 1) * space) / letterNum;

        StringBuilder vCode = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < letterNum; i++) {
            int ascii = random.nextInt(26) + 97;
            byte[] bs = {(byte) ascii};
            String letter = new String(bs);
            vCode.append(letter);
            graphics.setColor(getRandomColor());
            graphics.setFont(new Font("Gulim", Font.BOLD, 70));
            graphics.drawString(letter, space + (letterWidth + space) * i, height - space);
        }
        HttpSession session = request.getSession();
        session.setAttribute("vCode", vCode.toString());

        ImageIO.write(image, "png", response.getOutputStream());
    }

    private Color getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
}
