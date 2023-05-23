package com.DTO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
public class BookingDto {

    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("totalprice")
    @Expose
    private int totalprice;
    @SerializedName("depositpaid")
    @Expose
    private boolean depositpaid;
    @SerializedName("bookingdates")
    @Expose
    private BookingDatesDto bookingdates;
    @SerializedName("additionalneeds")
    @Expose
    private String additionalneeds;

    @Override
    public String toString() {
        return "Booking [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice + ", depositpaid=" + depositpaid
                + ", bookingdates=" + bookingdates + ", additionalneeds=" + additionalneeds + "]";
    }
}
