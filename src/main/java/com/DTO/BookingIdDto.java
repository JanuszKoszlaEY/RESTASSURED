package com.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingIdDto {
//    @SerializedName("bookingid")
//    @Expose
//    private int bookingid;
//    @SerializedName("booking")
//    @Expose
//    private BookingDto booking;


    private int bookingid;
    private BookingDto booking;
}
