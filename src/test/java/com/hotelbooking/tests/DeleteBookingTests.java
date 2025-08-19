package com.hotelbooking.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookingTests extends TestBase {

    @Test(priority = 1)
    public void deleteBooking_Positive() {
        int bookingId = 80104;
        String url = BASE_URI_BOOKING + "/deleteBookingById/" + bookingId;

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + accessToken)
                .accept(ContentType.JSON)
                .delete(url);

        printResponseDetails("Delete Booking - Positive", url, response);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains(String.valueOf(bookingId)));
    }
}
