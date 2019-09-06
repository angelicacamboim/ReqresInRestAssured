package reqres.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;
import reqres.rest.core.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UsersTest extends BaseTest {

    @Test
    public void createUser(){
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "Angel");
        user.put("job", "manager");

        given()
                    .body(user)
                .when()
                    .post("/users")
                .then()
                    .statusCode(201)
                    .body("name", Matchers.is("Angel"))
                    .body("job", Matchers.is("manager"))
                    .body("id", Matchers.notNullValue())

        ;

    }
    @Test
    public void updateUser(){
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "Angel update");
        user.put("job", "manager it");

        given()
                    .body(user)
                .when()
                    .put("/users/2")
                .then()
                    .statusCode(200)
                    .body("name", Matchers.is("Angel update"))
                    .body("job", Matchers.is("manager it"))
        ;

    }
    @Test
    public void deleteUser(){
        given()
                .when()
                    .delete("/users/3")
                .then()
                    .statusCode(204)
        ;

    }
    @Test
    public void listUsers(){

        given()
                    .queryParam("page", "1")
                .when()
                    .get("/users")
                .then()
                    .statusCode(200)
                    .body("page", Matchers.is(1))
                    .body("per_page", Matchers.is(6))
                    .body("data", Matchers.hasSize(6))

        ;

    }
    @Test
    public void listSingleUser(){
        given()
                .when()
                    .get("/users/2")
                .then()
                    .statusCode(200)
                    .body("data.id", Matchers.is(2))
                    .body("data.email", Matchers.is("janet.weaver@reqres.in"))
                    .body("data.first_name", Matchers.is("Janet"))
                    .body("data.last_name", Matchers.is("Weaver"))
                    .body("data.avatar", Matchers.is("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"))

        ;

    }
    @Test
    public void notFoundSingleUser(){

        given()
                .when()
                    .get("/users/23")
                .then()
                    .statusCode(404)
        ;

    }
    @Test
    public void validarHeader(){
        RestAssured.given()
                .when()
                    .get("users")
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .contentType(Matchers.containsString("utf-8"));

    }
}
