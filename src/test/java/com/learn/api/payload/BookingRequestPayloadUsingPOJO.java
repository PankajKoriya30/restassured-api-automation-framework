package com.learn.api.payload;

public class BookingRequestPayloadUsingPOJO {

    public static Booking createBookingRequestPayload(){
        BookingDates bookingDates = new BookingDates("2026-01-01", "2026-01-10");

        Booking booking = new Booking(
                "Vamika",
                "Koriya",
                1500,
                true,
                bookingDates,
                "Breakfast");

        return booking;
    }
}
