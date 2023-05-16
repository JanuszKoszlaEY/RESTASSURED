package com.Lesson05;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

public class BaseTest {


    static Long MAX_TIMEOUT = 3000L;


@BeforeClass
public static void setup() {

    ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
    resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
    RestAssured.responseSpecification = resBuilder.build();
}

    }
