package spru.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/v1/users")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}