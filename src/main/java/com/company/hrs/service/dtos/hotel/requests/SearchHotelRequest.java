package com.company.hrs.service.dtos.hotel.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchHotelRequest {
    private Long cityId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Byte roomCount;
    private Byte adultCount;
    private Byte childreenCount;

}
