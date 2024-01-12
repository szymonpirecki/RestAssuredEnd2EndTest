package utils.response;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import models.Data;
import models.GetStudentResponse;
import models.Student;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseValidator {

    public static void validate_response_code(Response response, int expectedCode) {
        response
                .then()
                .statusCode(expectedCode);
    }


    public static void validate_GET_student_response(Response response, Student expectedStudent) {
        if (expectedStudent == null) {
            boolean status = response
                    .then()
                    .extract()
                    .jsonPath().getBoolean("status");
            assertThat(status).isFalse();
        } else {
            Data studentData = response
                    .then()
                    .statusCode(200)
                    .extract()
                            .as(new TypeRef<GetStudentResponse>() {
                    }).getData();

            assertThat(studentData)
                    .usingRecursiveComparison()
                    .ignoringFields("id")
                    .isEqualTo(new Data(expectedStudent));
        }
    }
}