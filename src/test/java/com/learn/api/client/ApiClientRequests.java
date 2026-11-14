package com.learn.api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClientRequests {

    //GET Request
    public static Response get(RequestSpecification requestSpecification,
                               String endpoint) {
        // code to send GET request to the specified endpoint
        return RestAssured.given()
                .spec(requestSpecification)
                .when()
                .get(endpoint);


    }

    //POST Request
    public static Response post(RequestSpecification requestSpecification,
                                Object requestBody,
                                String endpoint) {
        // code to send POST request to the specified endpoint
        return RestAssured.given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    //Put Request
    public static Response put(RequestSpecification requestSpecification,
                               Object requestBody,
                               String endpoint) {
        return RestAssured.given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .put(endpoint);
    }

    //Delete Request
    public static Response delete(RequestSpecification requestSpecification,
                              String endpoint){
        return RestAssured.given()
                .spec(requestSpecification)
                .when()
                .delete(endpoint);
    }

    // Patch Request
    public static Response patch(RequestSpecification requestSpecification,
                               Object requestBody,
                               String endpoint) {
        return RestAssured.given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .patch(endpoint);
    }

}