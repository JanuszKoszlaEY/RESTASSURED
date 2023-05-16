package com.userJourney.POST;

import com.DTO.BookingDto;
import com.configuration.RequestSpec;
import com.configuration.ResponseSpec;
import com.endpoints.Endpoints;
import io.restassured.response.Response;

import static com.endpoints.Endpoints.booking;
import static io.restassured.RestAssured.given;

public class CreateBooking {
    public static Response createBooking(BookingDto bookingDto) {
        return given(
                    RequestSpec.get()
                    .body(bookingDto),
                    ResponseSpec.get()
                )
                .post(booking);
    }
}
