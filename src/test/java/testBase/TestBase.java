package testBase;

import configuration.handler.EnvironmentHandler;
import lombok.extern.slf4j.Slf4j;
import models.Student;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class TestBase {

    public static String studentDetailsEndpoint;
    public static String specificStudentDetailsEndpoint;
    public static Student student;

    @BeforeAll
    static void beforeAll() {
        initializeTestEnvironment();
        studentDetailsEndpoint = System.getProperty("endpoints-studentDetails");
        specificStudentDetailsEndpoint= System.getProperty("endpoints-specificStudentDetails");
        student = new Student("Tomasz", "Jonasz", "Fromage", "11-12-92");
    }

    public static void initializeTestEnvironment() {
        EnvironmentHandler.setEnvironmentProperties();
        EnvironmentHandler.initializeRestAssuredLogging();
        EnvironmentHandler.applyBaseUriSettings();
    }
}