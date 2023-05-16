package com.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ResponseSpec {
    private final static Long MAX_TIMEOUT = 3000l;

    private static ResponseSpecification spec;

    public static ResponseSpecification get(){

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();
        spec=resBuilder.build();
        return spec;
    }
}
