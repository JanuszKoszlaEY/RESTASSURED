package com.Lesson07;

import com.Lesson05.BaseTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RepeatRequestTest extends BaseTest {

    @Test
    public void repeatRequestTest(){
        try {
            Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> this.getStatus() == HttpStatus.SC_OK);
        } catch (ConditionTimeoutException e) {
            throw new AssertionError("Timeout after " + 5 + " seconds. " +
                    "Result is different then: " + HttpStatus.SC_OK + e.getMessage());
        }
    }
    public int getStatus() {
        return given()
                .relaxedHTTPSValidation()
                .accept(ContentType.JSON)
                .get("https://dummyjson.com/products/category/")
                .then()
                .extract()
                .statusCode();
    }

}
