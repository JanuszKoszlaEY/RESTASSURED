package com.DTO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class BookingDatesDto {
    @SerializedName("checkin")
    @Expose
    private String checkin;

    @SerializedName("checkout")
    @Expose
    private String checkout;
    @Override
    public String toString() {
        return "Bookingdates [checkin=" + checkin + ", checkout=" + checkout + "]";
    }
}



