package utils.providers;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import testBase.TestBase;

import static io.restassured.RestAssured.given;

public class RequestSpecificationProvider extends TestBase {

    public static RequestSpecification get_spec_for_POST_student(){
        return given()
                .basePath(studentDetailsEndpoint)
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification get_spec_for_GET_or_DELETE_student(int studentId){
        return given()
                .basePath(specificStudentDetailsEndpoint)
                .pathParam("id", studentId);
    }

    public static RequestSpecification get_spec_for_PUT_student(int id) {
        return given()
                .basePath(specificStudentDetailsEndpoint)
                .contentType(ContentType.JSON)
                .pathParam("id", id);
    }
}