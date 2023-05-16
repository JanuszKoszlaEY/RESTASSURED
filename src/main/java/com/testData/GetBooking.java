package com.testData;

import com.DTO.BookingDatesDto;
import com.DTO.BookingDto;

public class GetBooking {

    public static BookingDto get(){
        BookingDatesDto bookingDatesDTO = new BookingDatesDto("2020-03-25", "2020-03-27");
        BookingDto booking = BookingDto.builder()
            .firstname("Janusz")
            .lastname("Kowalski")
            .totalprice(200)
            .depositpaid(false)
            .bookingdates(bookingDatesDTO)
            .additionalneeds("Food")
            .build();
        return booking;
    }
}
