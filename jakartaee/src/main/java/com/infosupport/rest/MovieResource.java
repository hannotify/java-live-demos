package com.infosupport.rest;

import com.infosupport.model.DatabaseBean;
import com.infosupport.rest.dto.MovieDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/movie")
public class MovieResource {
    @Inject
    DatabaseBean databaseBean;

    @GET
    @Produces("application/json")
    public Response get() {
        return Response
                .accepted(new MovieDto("Barbie"))
                .build();
    }

    @POST
    public void addMovie(@FormParam("name") String name) {
        databaseBean.addMovie(name);
    }
}
