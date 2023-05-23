package com.Lesson04;

import com.DTO.BookingDto;
import com.DTO.BookingIdDto;
import com.configuration.RequestSpec;
import com.configuration.ResponseSpec;
import com.endpoints.Endpoints;
import com.testData.GetBooking;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class CreateBookingPOJOTest {

      @Test
    public void createBookingWithPOJO1Test() {
        // Create body using POJOs
        BookingDto booking = GetBooking.get();
        // get data from using dto
        Response response = given(RequestSpec.get()) //request config and logging added from separate class
            .body(booking)                           //serialisation
            .post(Endpoints.booking);

        BookingIdDto bookingid = response.as(BookingIdDto.class); //deserialisation
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200. Present: " + response.getStatusCode());

        // Verify All fields
        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());

        // List<InvoiceFieldDto> list = Arrays.asList(LastResponse.received().answeredBy(actor).getBody().as(InvoiceFieldDto[].class));
    }

    @Test
    public void createBookingWithPOJO2Test() {

        BookingDto booking = GetBooking.get();                                          // get data from using dto
        Response response = given(RequestSpec.get().body(booking), ResponseSpec.get())  //wait for response configuration added
            .post(Endpoints.booking);

        BookingIdDto bookingid = response.as(BookingIdDto.class);  //deserialisation
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code should be 200. Present: " + response.getStatusCode());
        Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
    }

}
