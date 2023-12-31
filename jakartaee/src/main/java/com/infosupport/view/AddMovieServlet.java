package com.infosupport.view;

import com.infosupport.events.MovieAdded;
import com.infosupport.model.DatabaseBean;
import com.infosupport.model.MovieDto;
import com.infosupport.model.MovieEntity;
import jakarta.ejb.EJB;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/addMovie")
public class AddMovieServlet extends HttpServlet {
    @EJB
    DatabaseBean databaseBean;

    @Inject
    Event<MovieAdded> movieAddedEvent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String homeAlone = "Home Alone";
        databaseBean.addMovie(new MovieDto(homeAlone, BigDecimal.TEN, LocalDate.now()));
        movieAddedEvent.fire(new MovieAdded(new MovieEntity(homeAlone)));
    }
}
