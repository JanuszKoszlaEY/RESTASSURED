package com.Lesson02;

import com.commonData.CommonData;
import com.endpoints.Endpoints;

import com.utilities.PropertyManager;
import io.restassured.RestAssured;
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
        Response response = RestAssured.get(PropertyManager.getInstance().getURL() + Endpoints.booking);
        response.print();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_OK,"Response status code is not 200");

        List<Integer> bookingIds = response.jsonPath().getList("bookingIds");
        Assert.assertFalse(bookingIds.isEmpty(),"No booking ids found");
    }

    @Test
    public void getBookingTest(){
        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.get(URL + Endpoints.booking + "/1");
        response.print();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"Response status code is not 200");
        String foundFirstName = response.jsonPath().getString("firstname");
        String foundLastName = response.jsonPath().getString("lastname");
        String foundCheckIn = response.jsonPath().getString("bookingdates.checkin");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(foundFirstName,"Sally");
        softAssert.assertEquals(foundLastName,"Brown");
        softAssert.assertFalse(foundCheckIn.isEmpty());

    }

}
