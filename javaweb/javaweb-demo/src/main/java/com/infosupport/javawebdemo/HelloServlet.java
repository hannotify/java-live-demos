package com.infosupport.javawebdemo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Om een input-veld uit een form uit te lezen.
        // <input type="text" name="emailAddress">
        request.getParameter("emailAddress");

        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }

    public void destroy() {
    }
}