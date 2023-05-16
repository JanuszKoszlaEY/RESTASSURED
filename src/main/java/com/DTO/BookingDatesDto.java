package com.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Builder
//public class BookingDatesDto {
//    @SerializedName("checkin")
//    @Expose
//    private String checkin;
//
//    @SerializedName("checkout")
//    @Expose
//    private String checkout;
//    @Override
//    public String toString() {
//        return "Bookingdates [checkin=" + checkin + ", checkout=" + checkout + "]";
//    }
//}


public class BookingDatesDto {

    private String checkin;
    private String checkout;
    @Override
    public String toString() {
        return "Bookingdates [checkin=" + checkin + ", checkout=" + checkout + "]";
    }
}
