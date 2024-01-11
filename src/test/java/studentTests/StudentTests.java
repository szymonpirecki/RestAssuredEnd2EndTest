package studentTests;

import org.junit.jupiter.api.Test;
import testBase.TestBase;
import utils.DataStore;
import utils.RequestBuilder;

public class StudentTests extends TestBase {


    @Test
    public void student_CRUD_test() {
        DataStore.STUDENT_ID = RequestBuilder
                .send_POST_student(student)
                .then()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getInt("id");

        RequestBuilder
                .send_GET_student(DataStore.STUDENT_ID)
                .then()
                .log().body();


    }
}