package projectReqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utility.TestBase;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class listSingleUser extends TestBase {

    @Test
    public void getUser(){

        Response response =
                given()
                        .accept(ContentType.JSON)
                        .queryParam("id", 3)
                        .log().uri()
                        .when()
                        .get().prettyPeek();

        Assertions.assertEquals(200, response.statusCode());
       Assertions.assertTrue(response.body().asString().contains("Emma"));

       System.out.println(response.body().asString());







    }
}
