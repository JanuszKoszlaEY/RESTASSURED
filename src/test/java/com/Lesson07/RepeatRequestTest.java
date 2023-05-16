package com.Lesson07;

import com.Lesson05.BaseTest;
import io.restassured.http.ContentType;
import org.awaitility.Awaitility;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class RepeatRequestTest extends BaseTest {

    @Test
    public void repeatRequestTest() throws Exception{
        Awaitility.await().atMost(5, TimeUnit.SECONDS).until(() -> this.getStatus() == 200);
    }

    public int getStatus() {
        return given()
                .accept(ContentType.JSON)
                .get("https://dummyjson.com/products/category/")
                .then()
                .extract()
                .statusCode();
    }

}
