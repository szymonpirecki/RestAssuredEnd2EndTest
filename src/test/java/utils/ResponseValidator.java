package utils;

import io.restassured.response.Response;

public class ResponseValidator {
    static Response response;

    public static void validate_PUT_student_response() {
        response
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getInt("id");
    }
}
