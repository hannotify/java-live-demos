import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MovieResourceTest {
    @BeforeAll
    public void setup() {
        //when().put(restUrl())
    }

    @Test
    public void testGet() {
        given()
                .when().get(restUrl("movies"))
                .then().contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
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
