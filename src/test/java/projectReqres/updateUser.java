package projectReqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utility.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class updateUser extends TestBase {

    static int userID=3;


    @Order(1)
    @Test
    public void putRequest() {

        Map<String,Object> updateUser=new HashMap<>();


        updateUser.put("email", "emma.wong@reqres.in");
        updateUser.put("first_name", "Emma");
        updateUser.put("last_name", "Watson");
        updateUser.put("avatar", "https://reqres.in/img/faces/3-image.jpg");

        JsonPath jp= (JsonPath) given().log().uri()
                .queryParam("id", userID)
                .contentType(ContentType.JSON)
                .body(updateUser)
                .when().put().prettyPeek()
                .then().statusCode(200)
                .body("last_name",is( "Watson"))
                .extract().jsonPath();


    }

    @Order(2)
    @Test

    public void getUpdatedUser () {

        Response response = RestAssured.get("/"+userID).prettyPeek();
        assertEquals(200, response.statusCode());
        Assertions.assertFalse(response.body().asString().contains("Watson"));



    }

}
