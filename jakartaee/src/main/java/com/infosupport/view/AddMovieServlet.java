package com.infosupport.view;

import com.infosupport.model.DatabaseBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addMovie")
public class AddMovieServlet extends HttpServlet {
    @EJB
    DatabaseBean databaseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        databaseBean.addMovie("Home Alone");

    }
}
