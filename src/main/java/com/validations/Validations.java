package com.validations;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class Validations {
    public static void Validate(ValidatableResponse toValidate){
        Assert.assertEquals(toValidate.extract().statusCode(), HttpStatus.SC_OK); //version1 TestNG
        toValidate.statusCode(HttpStatus.SC_OK); // version2 - RestAssured
    }
}
