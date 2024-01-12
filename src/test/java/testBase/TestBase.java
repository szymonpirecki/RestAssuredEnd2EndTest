package testBase;

import configuration.handler.EnvironmentHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class TestBase {

    public static String studentDetailsEndpoint;
    public static String specificStudentDetailsEndpoint;

    @BeforeAll
    static void beforeAll() {
        initializeTestEnvironment();
        studentDetailsEndpoint = System.getProperty("endpoints-studentDetails");
        specificStudentDetailsEndpoint= System.getProperty("endpoints-specificStudentDetails");
    }

    public static void initializeTestEnvironment() {
        EnvironmentHandler.setEnvironmentProperties();
        EnvironmentHandler.initializeRestAssuredLogging();
        EnvironmentHandler.applyBaseUriSettings();
    }
}