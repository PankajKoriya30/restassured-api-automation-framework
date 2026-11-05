package com.learn.api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class BookingGetTest {

    private static final String baseUrl =
            "https://restful-booker.herokuapp.com";

    @Test
    public void verifyGetAllBookingIds(){

        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .accept(ContentType.JSON)
                .when().get("/booking");

        // validate the http status code
        Assert.assertEquals(response.getStatusCode(), 200,
                "Status code returned other than 200");

        // validate the response content type
        Assert.assertTrue(response.getContentType().contains("application/json"),
                "Response type is not a JSON");

        // Extract the JSON response as a list
        List<Map<String, Object>> bookings = response.jsonPath().getList("$");

        // Validate that the response is a JSON array
        Assert.assertNotNull(
                bookings,
                "Booking response should not be null"
        );

        // Validate every returned booking ID
        for(Map<String, Object> booking: bookings){
            Assert.assertNotNull(
                    booking.get("bookingid"),
                    "Each booking must contain a bookingid"
            );
        }
        System.out.println(
                "GET /booking executed successfully."
        );

        System.out.println(
                "Number of booking IDs returned: " + bookings.size()
        );

    }
}
