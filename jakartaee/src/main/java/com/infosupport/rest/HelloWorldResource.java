package com.infosupport.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(title = "Hello World", version = "0.1"))
@Path("hello")
public class HelloWorldResource {
    @GET
    @Operation(summary = "Says hello from this REST API.")
    public String hello() {
        return "Hello from the REST API!";
    }
}
