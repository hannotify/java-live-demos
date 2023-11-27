package com.infosupport.view;

import com.infosupport.model.DatabaseBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @EJB
    DatabaseBean databaseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String list = databaseBean.getAllMovies().stream()
                .map(m -> "<li>%s</li>%n".formatted(m.getName()))
                .reduce(String::concat)
                .orElse("");


        resp.getWriter().append("<html><head></head><body><ul>%s</ul></body></html>".formatted(list));
    }
}
