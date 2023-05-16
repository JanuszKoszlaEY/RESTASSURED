package com.Lesson06;

import com.DTO.BookingDto;
import com.DTO.BookingIdDto;
import com.Lesson05.BaseTest;
import com.configuration.RequestSpec;
import com.endpoints.Endpoints;
import com.testData.GetBooking;
import com.userJourney.POST.CreateBooking;
import com.validations.Validations;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingPOJO2Test extends BaseTest {

    @Test
    public void createBookingWithPOJO5Test() {
        BookingDto booking = GetBooking.get();
        ValidatableResponse toValidate = CreateBooking.createBooking(booking).then();
        Validations.Validate(toValidate);
    }
}
