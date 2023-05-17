package com.Lesson01;

import com.endpoints.Endpoints;
import com.utilities.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredDifferentSyntax {

    @Test
    public void healthTest(){

        given()
            .relaxedHTTPSValidation()
        .when()
            .get("https://restful-booker.herokuapp.com/ping")
        .then()
            .assertThat().statusCode(201)
        .log().all();

    }

    @Test
    public void healthTest2(){

        with()
            .relaxedHTTPSValidation()
        .when()
            .get("https://restful-booker.herokuapp.com/ping")
        .then()
            .assertThat().statusCode(201)
            .log().all();

    }

    @Test
    public void healthTest3(){

        with()
            .relaxedHTTPSValidation()
            .get("https://restful-booker.herokuapp.com/ping")
        .then()
            .assertThat().statusCode(HttpStatus.SC_CREATED)   //http code from interface
            .log().all();

    }

    @Test
    public void BookingTest4(){
        baseURI = "https://restful-booker.herokuapp.com/";
        given()
            .relaxedHTTPSValidation()
        .when()
            .get("booking")
        .then()
            .assertThat().statusCode(HttpStatus.SC_OK)   //http code from interface
            .log().all();

    }

    @Test
    public void BookingTest5(){

        given()
            .relaxedHTTPSValidation()
            .baseUri(PropertyManager.getInstance().getURL())
            .basePath(Endpoints.booking)
            .log().all()
        .when()
            .get()
        .then()
            .assertThat().statusCode(HttpStatus.SC_OK);   //http code from interface

    }

    @Test
    void getSmartphones() {

        RestAssured.baseURI = "https://dummyjson.com/";
        RestAssured.basePath = "products/category/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        RequestSpecification httpRequestConfig = given().relaxedHTTPSValidation();
        Response response = httpRequestConfig.request(Method.GET, "smartphones"); //another form of request

//        Response response = httpRequestConfig.get("smartphones");

        String responseBody = response.toString(); // there is no log so I print response
        System.out.println("response: " + responseBody);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);   //http code from interface
    }

    @Test
    void getSmartphones2() {

        RestAssured.baseURI = "https://dummyjson.com/";
        RestAssured.basePath = "products/category/";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL); // full log when fails
        RequestSpecification httpRequestConfig = given().relaxedHTTPSValidation();
        Response response = httpRequestConfig.request(Method.GET, "smartphones");

//        Response response = httpRequestConfig.get("smartphones");

        response.then().statusCode(HttpStatus.SC_PROCESSING);   // to fail

    }


}
