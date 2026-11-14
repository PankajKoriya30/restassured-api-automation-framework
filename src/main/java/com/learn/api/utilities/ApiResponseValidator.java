package com.learn.api.utilities;

import io.restassured.response.Response;

public class ApiResponseValidator {

    // Validate the response status code
    public static void validateResponseStatusCode(Response response,
                                                  int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        if (actualStatusCode != expectedStatusCode) {
            throw new AssertionError("Expected status code: " + expectedStatusCode +
                    ", but got: " + actualStatusCode);
        }
    }

    // Validate the response content type
    public static void validateResponseContentType(Response response,
                                                   String expectedContentType) {
        String actualContentType = response.getContentType();
        if (!actualContentType.contains(expectedContentType)) {
            throw new AssertionError("Expected content type: " + expectedContentType +
                    ", but got: " + actualContentType);
        }
    }

    // Validate that the response body is not null
    public static void validateResponseBodyNotNull(Response response) {
        if (response.getBody() == null) {
            throw new AssertionError("Response body is null");
        }
    }
}
