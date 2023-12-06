package com.infosupport.jwt;

import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.util.KeyUtils;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.temporal.ChronoUnit;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;

@Path("/user")
public class UserResource {
    @Inject
    UserRepository userRepository;

    @GET
    @Path("/permitAll")
    @PermitAll
    public String permitAll() {
        return "This GET endpoint is reachable by everyone!";
    }

    @GET
    @Path("/permitAdmin")
    @RolesAllowed("admin")
    public String permitAdmin() {
        return "This GET endpoint is only reachable by logged-in users in the 'admin' group!";
    }

    @GET
    @Path("/permitReader")
    @RolesAllowed("reader")
    public String permitReader() {
        return "This GET endpoint is only reachable by logged-in users in the 'reader' group!";
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public void register(UserDto input) {
        userRepository.add(input.getUsername(), input.getPassword(), input.getRoles());
    }

    @POST
    @Path("/login")
    @Consumes(APPLICATION_JSON)
    public String login(UserDto input) throws GeneralSecurityException, IOException {
        var username = input.getUsername();
        var password = input.getPassword();

        var userDto = userRepository.findByUsernameAndPassword(username, password);
        return issueToken(userDto);
    }

    private String issueToken(UserDto userDto) throws GeneralSecurityException, IOException {
        return Jwt.issuer("infosupport")
                .subject("movies")
                .upn(userDto.getUsername())
                .claim("username", userDto.getUsername())
                .groups(userDto.getRoles())
                .issuedAt(now())
                .expiresAt(now().plus(30, MINUTES))
                .sign(KeyUtils.readPrivateKey("META-INF/private-key.pem"));
    }
}
