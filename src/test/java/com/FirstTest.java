package com;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.expect;

public class FirstTest {

    @Test
    public void FirstTest() throws InterruptedException {
        RestAssured.baseURI ="https://restful-booker.herokuapp.com/booking";
        RestAssured.given().log().all().get();



        expect().statusCode(200).when().get();
    }
}
