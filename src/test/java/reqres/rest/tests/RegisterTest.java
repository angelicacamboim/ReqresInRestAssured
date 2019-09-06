package reqres.rest.tests;

import org.hamcrest.Matchers;
import org.junit.Test;
import reqres.rest.core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RegisterTest extends BaseTest{

    @Test
    public void successfulRegister(){
        Map<String, String> register = new HashMap<String, String>();
        register.put("email", "eve.holt@reqres.in");
        register.put("password", "cityslicka");

        given()
                    .body(register)
                .when()
                    .post("/register")
                .then()
                    .statusCode(200)
                    .body("token", Matchers.notNullValue())
                    .body("id", Matchers.notNullValue())
        ;

    }
    @Test
    public void unsuccessfulRegister(){
        Map<String, String> register = new HashMap<String, String>();
        register.put("email", "eve.holt@reqres.in");

        given()
                    .body(register)
                .when()
                    .post("/register")
                .then()
                    .statusCode(400)
                    .body("error", Matchers.is("Missing password"))
        ;

    }
}
