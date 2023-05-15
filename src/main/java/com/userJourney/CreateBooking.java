package com.userJourney;

import com.configuration.RestSpecification;
import com.endpoints.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class CreateBooking {
    protected Response createBooking() {
        // Create JSON body
        JSONObject body = new JSONObject();
        body.put("firstname", "Dmitry");
        body.put("lastname", "Shyshkin");
        body.put("totalprice", 150);
        body.put("depositpaid", false);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2020-03-25");
        bookingdates.put("checkout", "2020-03-27");
        body.put("bookingdates", bookingdates);
        body.put("additionalneeds", "Baby crib");

        // Get response
        Response response = RestAssured.given(RestSpecification.get()).contentType(ContentType.JSON).body(body.toString())
                .post(Endpoints.booking);
        return response;
    }
}
