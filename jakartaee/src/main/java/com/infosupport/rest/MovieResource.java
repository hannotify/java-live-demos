package com.infosupport.rest;

import com.infosupport.exception.MovieNotFoundException;
import com.infosupport.model.DatabaseBean;
import com.infosupport.rest.dto.MovieDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotSupportedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

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
        databaseBean.addMovie(name);
    }

    @PUT
    public void putMovie() {
        throw new NotSupportedException();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMovie(@PathParam("id") Integer id) throws MovieNotFoundException {
        databaseBean.deleteMovie(id);
        return Response.ok().build();
    }
}
