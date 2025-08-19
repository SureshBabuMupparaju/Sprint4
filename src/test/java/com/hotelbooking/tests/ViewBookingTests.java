package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewBookingTests extends TestBase {

    @Test(priority = 1)
    public void viewBookingList_Positive() {
        String url = BASE_URI_BOOKING + "/viewBookingList";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .accept(ContentType.JSON)
                .get(url);

        printResponseDetails("View Booking List - Positive", url, response);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch");
        Assert.assertTrue(response.getBody().asString().contains("bookingId"), "Booking list missing expected data");
        Assert.assertTrue(response.getTime() < 3000, "Response time too high");
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
    }

    @Test(priority = 2)
    public void viewBookingById_Positive() {
        int bookingId = 50101;
        String url = BASE_URI_BOOKING + "/viewBookById/" + bookingId;

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .accept(ContentType.JSON)
                .get(url);

        printResponseDetails("View Booking By ID - Positive", url, response);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(String.valueOf(bookingId)));
    }
}
