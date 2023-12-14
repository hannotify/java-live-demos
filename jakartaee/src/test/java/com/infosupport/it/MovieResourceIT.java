package com.infosupport.it;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MovieResourceIT {

    @Test
    public void testGet() {
        given()
                .when().get(restUrl("movies"))
                .then().contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    @Disabled
    public void testDelete() {
        given()
                .pathParam("id", 951)
                .when().delete(restUrl("movie/{id}"))
                .then().statusCode(200);

    }

    static String restUrl(String relativeUrl) {
        return "http://localhost:9080/movies/api/" + relativeUrl;
    }

}
