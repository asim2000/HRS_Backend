package com.company.hrs.service.dtos.hotelImage.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetHotelImageResponse {
    private Long id;
    @Column(name = "hotel_id")
    private Long hotelId;
    private String name;
}
