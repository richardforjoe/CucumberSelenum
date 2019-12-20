package base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class RestTest {


    @Test
    public void test_register() {

        String payload = "{\"FirstName\": \"Josh\",\n" +
                "\"LastName\": \"SinghAX\",\n" +
                "\"UserName\": \"richard-simpleuser001\"\n" +
                ",\"Password\": \"password1\"\n" +
                ",\"Email\": \"rich-someuser1@gmail.com\"\n" +
                "}";

        given().body(payload).
                when().
                post("http://restapi.demoqa.com/customer/register").
                then().
                assertThat().
                statusCode(201);
    }



}