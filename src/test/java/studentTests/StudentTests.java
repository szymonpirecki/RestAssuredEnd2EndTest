package studentTests;

import models.Student;
import org.junit.jupiter.api.Test;
import testBase.TestBase;
import utils.providers.StudentFactory;

import static utils.request.RequestBuilder.*;
import static utils.response.ResponseValidator.validate_GET_student_response;
import static utils.response.ResponseValidator.validate_response_code;

public class StudentTests extends TestBase {

    @Test
    public void student_CRUD_test() {
        //create
        Student student = StudentFactory.getRandomStudent();
        var response = send_POST_student(student);
        validate_response_code(response, 201);
        var studentId = response.jsonPath().getInt("id");

        //read
        validate_response_code(send_GET_student(studentId), 200);

        //update
        student.setMiddle_name(StudentFactory.getRandomName());
        validate_response_code(send_PUT_student(student, studentId), 200);
        validate_GET_student_response(send_GET_student(studentId), student);

        //delete
        validate_response_code(send_DELETE_student(studentId), 200);
        response = send_GET_student(studentId);
        validate_GET_student_response(response, null);
    }
}