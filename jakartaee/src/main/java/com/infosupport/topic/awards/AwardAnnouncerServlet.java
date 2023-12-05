package com.infosupport.topic.awards;

import com.infosupport.model.Actor;
import com.infosupport.model.Movie;
import com.infosupport.topic.AwardMessage;
import com.infosupport.topic.AwardsTopic;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet("/topic/announce")
public class AwardAnnouncerServlet extends HttpServlet {
    @Inject
    AwardsTopic topic;

    List<Movie> movies = List.of(
            new Movie("Barbie", Set.of(new Actor("Margot", "Robbie"), new Actor("Ryan", "Gosling"))),
            new Movie("Oppenheimer", Set.of(new Actor("Cilian", "Murphy"), new Actor("Emily", "Blunt"))),
            new Movie("The Bucket List", Set.of(new Actor("Jack", "Nicholson"), new Actor("Morgan", "Freeman"))),
            new Movie("The King's Speech", Set.of(new Actor("Colin", "Firth"), new Actor("Helena", "Bonham Carter"))),
            new Movie("Walk The Line", Set.of(new Actor("Joaquin", "Phoenix"), new Actor("Reese", "Witherspoon"))),
            new Movie("Inception", Set.of(new Actor("Leonardo", "DiCaprio"), new Actor("Elliot", "Page")))
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().append("Announcing an award!");
        announceAward(pickMovie());
    }

    private void announceAward(Movie movie) {
        topic.send(new AwardMessage("This movie has won an award!!", movie));
    }

    private Movie pickMovie() {
        return movies.get(ThreadLocalRandom.current().nextInt(movies.size() - 1));
    }
}
