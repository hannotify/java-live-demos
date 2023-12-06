package com.infosupport.rest.security.admin;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("admin")
@RolesAllowed("admin")
public class AdminResource {
    @GET
    public String helloAdmin() {
        return "Hello admin!";
    }
}
