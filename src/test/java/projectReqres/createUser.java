package projectReqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utility.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class createUser extends TestBase {

    static String newID="";


    @Order(1)
    @Test
    public void PostRequest() {

        Map<String,Object> newUserMap=new HashMap<>();


        newUserMap.put("email", "neo_james@reqres.in");
        newUserMap.put("first_name", "Neo");
        newUserMap.put("last_name", "James");
        newUserMap.put("avatar", "https://reqres.in/img/faces/4-image.jpg");

        JsonPath jp= (JsonPath) given().log().uri()
                .contentType(ContentType.JSON)
                .body(newUserMap)
                .when().post().prettyPeek()
                .then().statusCode(201)
                .body("first_name",is( "Neo"))
                .extract().jsonPath();

    newID=jp.getString("id");

    }


    @Order(2)
    @Test

    public void getPostedUser () {

        Response response = RestAssured.get("/"+newID).prettyPeek();
        assertEquals(404, response.statusCode());




    }

}
