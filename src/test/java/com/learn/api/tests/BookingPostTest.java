package com.learn.api.tests;

import com.learn.api.base.BaseTest;
import com.learn.api.client.ApiClientRequests;
import com.learn.api.constants.ApiEndpointsContants;
import com.learn.api.payload.Booking;
import com.learn.api.payload.BookingDates;
import com.learn.api.payload.BookingRequestPayloadUsingPOJO;
import com.learn.api.payload.BookingResponse;
import com.learn.api.utilities.ApiResponseValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookingPostTest extends BaseTest {

    @Test(dataProvider = "bookingData")
    public void verifyCreateBookingAPI(Booking booking){
        Response response =  ApiClientRequests.post(requestSpecification,
                //BookingPayloadUsingMap.createBookingPayload(),
                //BookingRequestPayloadUsingPOJO.createBookingRequestPayload(booking),
                booking,
                ApiEndpointsContants.POST_BOOKING);

        BookingResponse bookingResponse = response.as(BookingResponse.class);
        ApiResponseValidator.validateResponseStatusCode(
                response,
                200
        );
        Assert.assertNotNull(bookingResponse.getBookingid(),
                "Booking id is not created successfully");

        //validate the field bookingid is present in the response body
        ApiResponseValidator.validateJsonField(response, "bookingid");
        Assert.assertTrue(bookingResponse.getBookingid()>0,
                "Booking id is not created successfully");

        //Validate the field firstname
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), booking.getFirstname(),
                "Firstname is not matching with the expected value");
        Assert.assertEquals(bookingResponse.getBooking().getFirstname(), booking.getFirstname(),
                "Firstname is not matching with the expected value");

        //Validate the field lastname
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), booking.getLastname(),
                "Lastname is not matching with the expected value");

        //Validate the field totalprice
        Assert.assertEquals(response.jsonPath().getInt("booking.totalprice"), booking.getTotalprice(),
                "Total price is not matching with the expected value");

        System.out.println(response.asPrettyString());

    }

    @DataProvider(name = "bookingData")
    public Object[][] bookingDataProvider(){
        return new Object[][]{
                { new Booking("Vamika", "Koriya", 1500, true,
                        new BookingDates("2026-01-01", "2026-01-10"), "breakfast")},
                {new Booking("John", "Doe", 2000, false,
                        new BookingDates("2026-02-01", "2026-02-10"), "lunch")},
                {new Booking("Jane", "Smith", 2500, true,
                        new BookingDates("2026-03-01", "2026-03-10"), "dinner")}
        };
    }
}
