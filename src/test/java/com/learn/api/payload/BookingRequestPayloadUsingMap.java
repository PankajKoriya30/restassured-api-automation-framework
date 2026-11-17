package com.learn.api.payload;

import java.util.HashMap;
import java.util.Map;

public class BookingRequestPayloadUsingMap {

    public static Map<String, Object> createBookingPayload(){

        Map<String, Object> booking = new HashMap<>();
        booking.put("firstname", "Pankaj");
        booking.put("lastname", "Koriya");
        booking.put("totalprice", 1500);
        booking.put("depositpaid", true);

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2026-01-01");
        bookingDates.put("checkout", "2026-01-02");

        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast");

        return booking;
    }
}
