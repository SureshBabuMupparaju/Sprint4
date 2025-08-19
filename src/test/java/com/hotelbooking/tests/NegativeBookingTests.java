package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeBookingTests extends TestBase {

    @Test(priority = 1)
    public void viewBookingById_InvalidId() {
        int invalidId = 99999;
        String url = BASE_URI_BOOKING + "/viewBookById/" + invalidId;

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .accept(ContentType.JSON)
                .get(url);

        printResponseDetails("View Booking By ID - Invalid ID", url, response);

        Assert.assertEquals(response.getStatusCode(), 404, "Expected 404 for invalid booking ID");
    }

    @Test(priority = 2)
    public void viewBookingList_WithoutToken() {
        String url = BASE_URI_BOOKING + "/viewBookingList";

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .get(url);

        printResponseDetails("View Booking List - Without Token", url, response);

        Assert.assertEquals(response.getStatusCode(), 401, "Expected 401 for missing token");
    }
}
