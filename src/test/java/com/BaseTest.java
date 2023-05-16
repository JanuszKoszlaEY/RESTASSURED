package com;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public interface Constants {

        Long MAX_TIMEOUT = 3000l;

    }

@BeforeClass
public static void setup() {

    ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
    resBuilder.expectResponseTime(Matchers.lessThan(Constants.MAX_TIMEOUT));
    RestAssured.responseSpecification = resBuilder.build();
}

    }
