package com.userJourney.POST;

import com.configuration.RequestSpec;
import com.endpoints.Endpoints;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateBookingFromJSONObject {
    public static Response createBooking() {
        // Create JSON body


        JSONObject bookingDates = new JSONObject(Map.of("checkin", "2020-03-25", "checkout", "2020-03-27"));
        JSONObject body = new JSONObject();
        body.put("firstname", "Janusz");
        body.put("lastname", "Kowalski");
        body.put("totalprice", 200);
        body.put("depositpaid", false);
        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Food");

        Response response = given(RequestSpec.get()).body(body.toString()).post(Endpoints.booking);
        // Get response

        return response;
    }
}
