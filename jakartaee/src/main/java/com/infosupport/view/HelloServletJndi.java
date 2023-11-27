package com.infosupport.view;

import com.infosupport.model.DatabaseBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.crypto.Data;
import java.io.IOException;

@WebServlet("/hello-jndi")
public class HelloServletJndi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String list = "";
        try {
            InitialContext ic = new InitialContext();
            Object lookedUpObject = ic.lookup("java:app/movies/DatabaseBean");

            if (lookedUpObject instanceof DatabaseBean databaseBean) {
                list = databaseBean.getAllMovies().stream()
                        .map(m -> "<li>%s</li>%n".formatted(m.getName()))
                        .reduce(String::concat)
                        .orElse("");
            }
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().append("<html><head></head><body><ul>%s</ul></body></html>".formatted(list));
    }
}
