package com.learn.api.tests;

import com.learn.api.base.BaseTest;
import com.learn.api.client.ApiClientRequests;
import com.learn.api.constants.ApiEndpointsContants;
import com.learn.api.utilities.ApiResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BookingGetTest extends BaseTest {

    @Test
    public void verifyGetAllBookingIdsAPI(){

        Response response = ApiClientRequests.get(requestSpecification,
                ApiEndpointsContants.GET_BOOKINGS);

        // validate the http status code
        ApiResponseValidator.validateResponseStatusCode(
                response,
                200
        );

        // validate the response content type
        ApiResponseValidator.validateResponseContentType(
                response,
                "application/json"
        );

        ApiResponseValidator.validateResponseBodyNotNull(
                response
        );
    }
}
