package com.infosupport.jwt;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Set;

public class GenerateJwtTest {
    @Test
    public void generateJwt() throws GeneralSecurityException, IOException {
        UserResource.issueToken(new UserDto("joep", "ikeethannosontbijt", Set.of("manager")));
    }
}
