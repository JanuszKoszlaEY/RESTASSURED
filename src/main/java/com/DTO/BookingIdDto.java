package com.DTO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingIdDto {
    @SerializedName("bookingid")
    @Expose
    private int bookingid;
    @SerializedName("booking")
    @Expose
    private BookingDto booking;



}
