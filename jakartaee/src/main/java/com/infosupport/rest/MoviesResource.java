package com.infosupport.rest;

import com.infosupport.model.DatabaseBean;
import com.infosupport.rest.dto.MovieDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/movies")
public class MoviesResource {
    @Inject
    DatabaseBean databaseBean;

    @GET
    @Produces("application/json")
    public Response getAll() {
        var movies = databaseBean.getAllMovies()
                .stream()
                .map(MovieDto::fromEntity)
                .toList();

        return Response.ok().entity(movies).build();
    }
}
