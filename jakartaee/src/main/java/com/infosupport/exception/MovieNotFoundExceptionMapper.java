package com.infosupport.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MovieNotFoundExceptionMapper implements ExceptionMapper<MovieNotFoundException> {

    @Override
    public Response toResponse(MovieNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception)
                .build();    }
}
