package utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class TestBase {


    @BeforeAll
    public static void init(){
        baseURI="https://reqres.in/api/users";

    }

    @AfterAll
    public static void destroy(){
        reset();
    }
}
