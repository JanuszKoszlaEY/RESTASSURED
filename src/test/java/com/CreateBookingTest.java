package com;

import com.DTO.BookingDatesDto;
import com.DTO.BookingDto;
import com.DTO.BookingIdDto;
import com.configuration.RequestSpec;
import com.configuration.ResponseSpec;
import com.endpoints.Endpoints;
import com.testData.JsonPayloads;
import com.userJourney.CreateBooking;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static io.restassured.http.ContentType.JSON;

public class CreateBookingTest extends RequestSpec {

    @Test
    public void createBookingWithModifiedJSONObj() {
        String  jsonString = JsonPayloads.myJsonObject();
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .relaxedHTTPSValidation()
                .contentType(JSON)
                .log().all()
                .body(jsonString)
                .when()
                .post(Endpoints.booking)
                .then()
                .statusCode(200);
    }

    @Test
    public void createBookingWithJSONPureString() {
        String  jsonString = JsonPayloads.jsonPureString();
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .relaxedHTTPSValidation()
                .contentType(JSON)
                .log().all()
                .body(jsonString)
                .when()
                .post(Endpoints.booking)
                .then()
                .statusCode(200);
    }

    @Test
    public void createBookingWithJSONString() {
        String  jsonString = JsonPayloads.jsonString("Janusz","Json",150,false,"Parking");
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .relaxedHTTPSValidation()
                .contentType(JSON)
                .log().all()
                .body(jsonString)
                .when()
                .post(Endpoints.booking)
                .then()
                .statusCode(200);
    }

    @Test
    public void createBookingWithJSONFromMap() {
        Map<String, Object>  jsonAsMap = JsonPayloads.jsonFromJavaMap();
        given()
          .baseUri("https://restful-booker.herokuapp.com/")
          .relaxedHTTPSValidation()
          .log().all()
          .contentType(JSON)
          .body(jsonAsMap)
        .when()
            .post(Endpoints.booking)
        .then()
            .statusCode(200);
    }
    @Test
    public void createBookingWithJSONObject() {

        Response response = new CreateBooking().createBooking();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200, but it's not");

    }

    @Test
    public void createBookingWithPOJO1Test() {
        // Create body using POJOs

        BookingDto booking = getBooking();
        // Get response

        Response response = given(RequestSpec.get()).body(booking)
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

    @Test
    public void createBookingWithPOJO2Test() {
        // Create body using POJOs

        BookingDto booking = getBooking();
        // Get response
        Response response = given(RequestSpec.get().body(booking), ResponseSpec.get())
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
