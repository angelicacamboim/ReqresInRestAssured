package reqres.rest.tests;

import org.hamcrest.Matchers;
import org.junit.Test;
import reqres.rest.core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin(){
        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "eve.holt@reqres.in");
        login.put("password", "cityslicka");

         given()
                    .body(login)
                .when()
                    .post("/login")
                .then()
                    .statusCode(200)
                    .body("token", Matchers.notNullValue())
                 ;

    }
    @Test
    public void unsuccessfulLogin(){
        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "eve.holt@reqres.in");

        given()
                    .body(login)
                .when()
                    .post("/login")
                .then()
                    .statusCode(400)
                    .body("error", Matchers.is("Missing password"))
        ;

    }
}
