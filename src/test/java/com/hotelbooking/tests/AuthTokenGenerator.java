package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthTokenGenerator {

    public static String generateToken() {
        String tokenURL = TestBase.BASE_URI_AUTH + "/token";

        Response response = RestAssured
                .given()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "soap-test")
                .formParam("client_secret", "tE2HfYI5z4BhX7R8pimTrxzMLsueUG27")
                .post(tokenURL);

        response.then().statusCode(200);

        return response.jsonPath().getString("access_token");
    }
}
