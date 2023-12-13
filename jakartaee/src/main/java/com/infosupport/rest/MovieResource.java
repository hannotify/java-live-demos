package com.infosupport.rest;

import com.infosupport.exception.MovieNotFoundException;
import com.infosupport.model.DatabaseBean;
import com.infosupport.model.MovieDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

@Path("/movie")
public class MovieResource {
    @Inject
    DatabaseBean databaseBean;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") Integer id) throws MovieNotFoundException {
        return Response.ok(databaseBean.retrieveMovie(id)).build();
    }

    @POST
    public void addMovie(@FormParam("name") String name) {
        databaseBean.addMovie(new MovieDto(name, BigDecimal.TEN, LocalDate.now()));
    }

    @PUT
    public void putMovie(MovieDto movie) {
        databaseBean.addMovie(movie);
    }

    @DELETE
    @Path("{id}")
    public Response deleteMovie(@PathParam("id") Integer id) throws MovieNotFoundException {
        databaseBean.deleteMovie(id);
        return Response.ok().build();
    }
}
