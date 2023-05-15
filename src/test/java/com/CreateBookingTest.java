package com;

import com.DTO.BookingDatesDto;
import com.DTO.BookingDto;
import com.DTO.BookingIdDto;
import com.configuration.RestSpecification;
import com.endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTest extends RestSpecification {
    @Test
    public void createBookingWithPOJOTest() {
        // Create body using POJOs

        BookingDto booking = getBooking();
        // Get response
        Response response = given(RestSpecification.get()).body(booking)
                .post(Endpoints.booking);
//        response.print();
        BookingIdDto bookingid = response.as(BookingIdDto.class);

        // Verifications
        // Verify response 200
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200, but it's not");

//        System.out.println("Request booking : " + booking);
//        System.out.println("Response booking: " + booking);

        // Verify All fields
        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
    }

    private BookingDto getBooking(){
        BookingDatesDto bookingDatesDTO = new BookingDatesDto("2020-03-25", "2020-03-27");
        BookingDto booking = BookingDto.builder()
                .firstname("Janusz")
                .lastname("Kowalski")
                .totalprice(200)
                .depositpaid(false)
                .bookingdates(bookingDatesDTO)
                .additionalneeds("Food")
                .build();
        return booking;
    }
}
