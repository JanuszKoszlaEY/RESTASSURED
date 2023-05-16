package com;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.*;

public class FirstTest {

    @Test
    public void FirstTest() {
        baseURI ="https://restful-booker.herokuapp.com/booking";
        useRelaxedHTTPSValidation();
        given().log().all().get();

        expect().log().all().statusCode(200).when().get();
    }
}
