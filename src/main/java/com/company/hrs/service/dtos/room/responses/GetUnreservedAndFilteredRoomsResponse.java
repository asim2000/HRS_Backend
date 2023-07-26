package com.company.hrs.service.dtos.room.responses;

import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import com.company.hrs.service.dtos.hotel.response.GetHomeHotelsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUnreservedAndFilteredRoomsResponse {
    private Long id;
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
    private GetHomeHotelsResponse hotel;
}
