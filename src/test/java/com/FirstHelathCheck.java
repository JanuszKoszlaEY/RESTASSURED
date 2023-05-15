package com;

import com.commonData.CommonData;
import com.endpoints.Endpoints;
import com.utilities.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FirstHelathCheck {

    @Test
    public void healthTest(){
        RestAssured.baseURI = PropertyManager.getInstance().getURL();
        given().relaxedHTTPSValidation()
        .when()
//        get("https://restful-booker.herokuapp.com/ping").
            .get(Endpoints.ping)
//                .get(Endpoints.booking)
        .then()
            .assertThat().statusCode(HttpStatus.SC_CREATED)
        .log().all();

    }

}
