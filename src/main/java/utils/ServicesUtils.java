package utils;

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


    public static double getRandomNumber(){
        double x = Math.random();
        return x;
    }
}

