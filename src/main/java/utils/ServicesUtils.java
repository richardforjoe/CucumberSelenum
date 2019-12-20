package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ServicesUtils {

private static double x = getRandomNumber();

    private static String payload = "{\"FirstName\": \""+x+"Virender\",\n" +
            "\"LastName\": \""+x+"Singh\",\n" +
            "\"UserName\": \""+x+"simpleuser001\"\n" +
            ",\"Password\": \""+x+"password1\"\n" +
            ",\"Email\": \""+x+"someuser@gmail.com\"\n" +
            "}";

    public enum HttpMethod {
        GET("get"), POST("post"), PATCH("patch"), PUT("put"), POST_BODY("post");

        private String method;
        private HttpMethod(String method){
            this.method = method;
        }



        public String getMethod() {
            return method;
        }
    }


    private static RequestSpecification request = given().accept(ContentType.JSON);

    private static RequestSpecification request_post = given().accept(ContentType.JSON).body(payload);



    public static Response execute(String endpoint, HttpMethod method){
        return execute(endpoint, method, true);
    }

    public static Response execute(String endpoint,
                                   HttpMethod method,
                                   boolean verifyStatusCode){

        System.out.println(endpoint);
        Response response = null;

        switch(method){
            case GET:
                response = request.get(endpoint);
                break;

            case POST:
                response = request.post(endpoint);
                break;

            case PATCH:
                response = request.patch(endpoint);
                break;
            case PUT:
                response = request.put(endpoint);
                break;
            case POST_BODY:
                response = request_post.post(endpoint);
                break;
        }

        response.then().log().all();

        if(verifyStatusCode){
            switch(method){
                case GET:
                    response.then().statusCode(200);
                    break;

                case POST:
                    response.then().statusCode(200);
                    break;

                case PATCH:
                    response.then().statusCode(200);
                    break;
                case PUT:
                    response.then().statusCode(200);
                    break;
                case POST_BODY:
                    response.then().statusCode(201);
                    break;
            }


        }

        return response;
    }

    public static double getRandomNumber(){
        double x = Math.random();
        return x;
    }
}

