package com.infosupport.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MovieNotFoundException extends Exception implements ExceptionMapper<MovieNotFoundException> {
    public MovieNotFoundException(String message) {
        super(message);
    }

    @Override
    public Response toResponse(MovieNotFoundException exception) {
        return null;
    }
}
