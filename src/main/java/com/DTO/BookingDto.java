package com.DTO;


import lombok.*;

@Builder
@Getter
@Setter
public class BookingDto {


    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesDto bookingdates;
    private String additionalneeds;

    @Override
    public String toString() {
        return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice + ", depositpaid=" + depositpaid
                + ", bookingdates=" + bookingdates + ", additionalneeds=" + additionalneeds + "]";
    }
}
