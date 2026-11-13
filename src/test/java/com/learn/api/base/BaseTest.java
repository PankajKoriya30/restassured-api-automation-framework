package com.learn.api.base;

import com.learn.api.utilities.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class BaseTest {

    protected RequestSpecification requestSpecification;

    @BeforeTest
    public void setup() throws IOException {
        ConfigReader.loadProperties("qa");
        String baseURL = ConfigReader.getProperty("baseurl");
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
        System.out.println(
                "API Base URL: " + baseURL);

    }
}
