package com.Lesson03;

import com.configuration.RequestSpec;
import com.endpoints.Endpoints;
import com.testData.JsonPayloads;
import com.userJourney.POST.CreateBookingFromJSONObject;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateBookingJSONStringTest {

    @Test
    public void createBookingWithModifiedJSONObj() {
        String  jsonString = JsonPayloads.myJsonObject();
        given(RequestSpec.get())
            .body(jsonString)
            .when()
            .post(Endpoints.booking)
            .then()
            .statusCode(200);
    }

    @Test
    public void createBookingWithJSONPureString() {
        String  jsonString = JsonPayloads.jsonPureString();
        given(RequestSpec.get())
            .body(jsonString)
            .when()
            .post(Endpoints.booking)
            .then()
            .statusCode(200);
    }

    @Test
    public void createBookingWithJSONString() {
        String  jsonString = JsonPayloads.jsonString("Janusz","Json",150,false,"Parking");
        given(RequestSpec.get())
            .body(jsonString)
            .when()
            .post(Endpoints.booking)
            .then()
            .statusCode(200);
    }

    @Test
    public void createBookingWithJSONFromMap() {
        Map<String, Object>  jsonAsMap = JsonPayloads.jsonFromJavaMap();
        given(RequestSpec.get())
          .body(jsonAsMap)
        .when()
            .post(Endpoints.booking)
        .then()
            .statusCode(200);
    }
    @Test
    public void createBookingWithJSONObject() {
        Response response = CreateBookingFromJSONObject.createBooking();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200, but it's not");
    }


}
