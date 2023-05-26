package com.Lesson07;

import com.Lesson05.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RepeatRequest2Test extends BaseTest {
    Response response;
    @Test
    public void repeatRequestTest(){
        try {
            Awaitility.await().atMost(5, TimeUnit.SECONDS).pollInterval(Duration.ofSeconds(1))
                    .until(() ->
                    {
                        response = given()
                                .log().all()
                                .relaxedHTTPSValidation()
                                .accept(ContentType.JSON)
                                .get("https://dummyjson.com/products/category/");
                        return response.getStatusCode()!=HttpStatus.SC_NOT_FOUND;
                    });
        } catch (ConditionTimeoutException e) {
            throw new AssertionError("Timeout after " + 5 + " seconds. " +
                    "Result is different then: " + HttpStatus.SC_OK + " ; " + e.getMessage());
        }
    }


}
