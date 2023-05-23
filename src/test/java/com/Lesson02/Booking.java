package com.Lesson02;

import com.commonData.CommonData;
import com.endpoints.Endpoints;

import com.utilities.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.border.SoftBevelBorder;
import java.util.List;

import static com.commonData.CommonData.URL;

public class Booking {

    @Test
    public void getBookingIdsTest(){
        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(PropertyManager.getInstance().getURL() + Endpoints.booking);  // URL from parameter file; path from interface
        response.print();   // there is no log so I print response

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"Response status code is not 200");

        List<Integer> bookingIds = response.jsonPath().getList("bookingIds");  //jsonPath used
        Assert.assertFalse(bookingIds.isEmpty(),"No booking ids found");
    }

    @Test
    public void getBookingTest(){
        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured.get(URL + Endpoints.booking + "/1");  // parameter as 'enum'
        response.print(); // there is no log so I print response

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"Response status code is not 200");
        String foundFirstName = response.jsonPath().getString("firstname");             //jsonPath used
        String foundLastName = response.jsonPath().getString("lastname");               //jsonPath used
        String foundCheckIn = response.jsonPath().getString("bookingdates.checkin");    //jsonPath used
        SoftAssert softAssert = new SoftAssert();  //SOFT ASSERT EXAMPLE

        softAssert.assertEquals(foundFirstName,"Sally"); // to fail
        softAssert.assertEquals(foundLastName,"Brown");
        softAssert.assertFalse(foundCheckIn.isEmpty());
        softAssert.assertAll();
    }

}
