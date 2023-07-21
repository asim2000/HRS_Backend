package com.company.hrs.service.dtos.hotelService.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllServiceByHotelResponse {
    private Long id;
    private String name;
}
