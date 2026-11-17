package com.learn.api.base;

import com.learn.api.utilities.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

public class BaseTest {

    protected RequestSpecification requestSpecification;

    @BeforeClass
    public void setup() throws IOException {
        ConfigReader.loadProperties("qa");
        String baseURL = ConfigReader.getProperty("baseurl");
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseURL)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
        System.out.println(
                "API Base URL: " + baseURL);

    }
}
