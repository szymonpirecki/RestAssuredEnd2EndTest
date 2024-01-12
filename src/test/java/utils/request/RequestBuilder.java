package utils.request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.Data;
import models.Student;
import testBase.TestBase;

import static utils.providers.RequestSpecificationProvider.*;

@Slf4j
public class RequestBuilder extends TestBase {

    public static Response send_POST_student(Student student) {
        Response response = RestAssured.given()
                .spec(get_spec_for_POST_student())
                .when()
                .body(student)
                .post();
        log.info(">>POST response: " + response.body().asString());
        return response;
    }

    public static Response send_GET_student(int studentId) {
        Response response = RestAssured.given()
                .spec(get_spec_for_GET_or_DELETE_student(studentId))
                .when()
                .get();
        log.info(">>GET response: " + response.body().asString());
        return response;
    }

    public static Response send_PUT_student(Student student, int studentId) {
        Data data = new Data(student);
        data.setId(studentId);
        Response response = RestAssured.given()
                .spec(get_spec_for_PUT_student(studentId))
                .when()
                .body(data)
                .put();
        log.info(">>PUT response: " + response.body().asString());
        return response;
    }

    public static Response send_DELETE_student(int studentId) {
        Response response = RestAssured.given()
                .spec(get_spec_for_GET_or_DELETE_student(studentId))
                .when()
                .delete();
        log.info(">>DELETE response: " + response.body().asString());
        return response;
    }
}