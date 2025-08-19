package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static String BASE_URI_BOOKING = "https://webapps.tekstac.com/HotelAPI/BookingService";
    protected static String BASE_URI_AUTH = "https://keycloak.tekstac.com/realms/soapdemo/protocol/openid-connect";
    protected static String accessToken;

    @BeforeClass
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        if (accessToken == null) {
            accessToken = AuthTokenGenerator.generateToken();
            System.out.println(" Access Token Generated Successfully.");
        }
    }

    protected void printResponseDetails(String testName, String url, Response response) {
        System.out.println("\n------------------- " + testName + " -------------------");
        System.out.println("Request URL: " + url);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response Body:\n" + response.getBody().asPrettyString());
        System.out.println("---------------------------------------------------\n");
    }
}
