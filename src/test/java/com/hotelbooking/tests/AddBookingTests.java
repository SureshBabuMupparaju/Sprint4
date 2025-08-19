package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddBookingTests extends TestBase {

    @Test(priority = 1)
    public void addBooking_Positive() {
        String url = BASE_URI_BOOKING + "/addBooking";

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.URLENC)
                .formParam("bookingId", "80104")
                .formParam("userId", "201")
                .formParam("bookedRoomNum", "501")
                .formParam("paymentStatus", "PAID")
                .formParam("startDate", "12/12/2021")
                .formParam("endDate", "12/12/2021")
                .post(url);

        printResponseDetails("Add Booking - Positive", url, response);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("80104"));
    }
}
