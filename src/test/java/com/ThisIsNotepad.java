package com;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThisIsNotepad {

    @Test
    void getSmartphones() {

        RestAssured.baseURI = "https://dummyjson.com/";
        RestAssured.basePath = "products/category/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RequestSpecification httpRequestConfig = RestAssured.given().relaxedHTTPSValidation().log().all();
//        Response response = httpRequestConfig.request(Method.GET, "smartphones");

        Response response = httpRequestConfig.get("smartphones");

        String responseBody = response.toString();
        System.out.println("response: " + responseBody);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}
