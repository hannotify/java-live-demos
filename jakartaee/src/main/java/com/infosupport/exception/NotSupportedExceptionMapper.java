package com.infosupport.exception;

import jakarta.ws.rs.NotSupportedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotSupportedExceptionMapper implements ExceptionMapper<NotSupportedException> {

    @Override
    public Response toResponse(NotSupportedException exception) {
        return Response.status(418).build();
    }
}
