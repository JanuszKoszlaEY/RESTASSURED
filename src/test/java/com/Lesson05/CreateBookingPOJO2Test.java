package com.Lesson05;

import com.DTO.BookingDto;
import com.DTO.BookingIdDto;
import com.configuration.RequestSpec;
import com.endpoints.Endpoints;
import com.testData.GetBooking;
import com.userJourney.POST.CreateBooking;
import com.validations.Validations;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingPOJO2Test extends BaseTest {

    @Test
    public void createBookingWithPOJO3Test() {

        BookingDto booking = GetBooking.get();
        Response response = given(RequestSpec.get())  //wait for response added in root class
            .body(booking)
            .post(Endpoints.booking);

        BookingIdDto bookingid = response.as(BookingIdDto.class);   //getData by POJO

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200. Present: " + response.getStatusCode());
        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());

        Assert.assertEquals(response.jsonPath().get("booking.firstname"),booking.getFirstname()); // getData by jsonPath
        //dataColumns[0].id
        //[0].userId
    }

    @Test
    public void createBookingWithPOJO4Test() {

        BookingDto booking = GetBooking.get();
    //    RestAssured.defaultParser = Parser.JSON;    // change parser
        given(RequestSpec.get())  //wait for response added in root class
            .body(booking)
            .post(Endpoints.booking)
        .then()
       //     .parser(String.valueOf(ContentType.JSON),Parser.JSON)
            .statusCode(HttpStatus.SC_OK)
            .body("booking.firstname", Matchers.equalToIgnoringCase(booking.getFirstname()));  //verification of body by RestAssured functionality
                                                                                                  // and jpath

    }

}
