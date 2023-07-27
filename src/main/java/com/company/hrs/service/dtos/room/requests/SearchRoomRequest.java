package com.company.hrs.service.dtos.room.requests;

import com.company.hrs.enums.RoomStyle;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRoomRequest {
    private Long hotelId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Byte roomCount;
    private Byte adultCount;
    private Byte childreenCount;
    @NotNull
    private RoomStyle roomStyle;
}
