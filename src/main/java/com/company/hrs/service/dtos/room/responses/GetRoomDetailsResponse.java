package com.company.hrs.service.dtos.room.responses;

import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomDetailsResponse {
    private Long id;
    private GetHotelDetailsResponse hotel;
    private String roomNumber;
    private Float pricePerNight;
    private Byte floor;
    private Byte adultCount;
    private Byte childreenCount;
    private RoomStatus roomStatus;
    private Byte twinBedCount;
    private Byte singleBedCount;
    private Boolean isPetAllowed;
    private Byte roomCount;
    private Byte showerCount;
    private String description;
    private RoomStyle roomStyle;
    private Boolean isClean;
    private Short roomSize;
}
